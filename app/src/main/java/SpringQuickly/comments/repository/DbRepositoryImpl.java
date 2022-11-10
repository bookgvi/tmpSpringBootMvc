package SpringQuickly.comments.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DbRepositoryImpl implements IRepository {
    @Override
    public void stored(String text) {
        System.out.printf("\"%s\" successfully stored in DB\n", text);
    }
}
