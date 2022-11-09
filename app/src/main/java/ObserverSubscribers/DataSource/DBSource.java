package ObserverSubscribers.DataSource;

import ObserverSubscribers.App;
import domain.Subscriber;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBSource implements ISubscriberSource {
    @Override
    public List<String> getList() throws IOException {
        List<String> subsNames = new ArrayList<>();
        JdbcTemplate jdbcTemplate = getDbSource();

//        jdbcTemplate.execute("drop table subscriber");
        List<Long> tableCounts = jdbcTemplate.query("SELECT count(*) FROM information_schema.tables WHERE table_name = ?",
                new RowMapper<Long>() {
                    @Override
                    public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getLong("count");
                    }
                },
                "subscriber");
        if (tableCounts.get(0) == null || tableCounts.get(0) == 0) {
            jdbcTemplate.execute("create table subscriber(id serial, name varchar(255), class_name varchar(255))");
            Properties props = new Properties();
            props.load(App.class.getResourceAsStream(ObserverSubscribers.Configuration.SUBSCRIBERS_LIST));
            props.forEach((key, val) -> {
                jdbcTemplate.update("insert into subscriber(name, class_name) values(?, ?)", key, val);
            });
        }
        List<Subscriber> subscriberList = jdbcTemplate.query(
                "select * from subscriber",
                new RowMapper<Subscriber>() {
                    @Override
                    public Subscriber mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Subscriber(rs.getLong("id"), rs.getString("name"), rs.getString("class_name"));
                    }
                });
        for (Subscriber sub : subscriberList) {
            subsNames.add(sub.getClassName());
        }
        return subsNames;
    }

    private JdbcTemplate getDbSource() throws IOException {
        Properties props = new Properties();
        props.load(this.getClass().getResourceAsStream(ObserverSubscribers.Configuration.APP_PROPS));
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.postgresql.Driver.class);
        dataSource.setUrl(props.getProperty("spring.datasource.url"));
        dataSource.setUsername(props.getProperty("spring.datasource.username"));
        dataSource.setPassword(props.getProperty("spring.datasource.password"));

//        Connection connection = dataSource.getConnection();
//        PreparedStatement statement = connection.prepareStatement("SELECT count(*) FROM information_schema.tables WHERE table_name = ?");
//        statement.setString(1, "subscriber");
//        ResultSet resultSet = statement.executeQuery();
        return new JdbcTemplate(dataSource);
    }
}
