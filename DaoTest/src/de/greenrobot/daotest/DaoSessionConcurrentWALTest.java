package de.greenrobot.daotest;

import android.os.Build;

import net.sqlcipher.database.SQLiteDatabase;

import java.io.File;
import java.lang.reflect.Method;

import de.greenrobot.dao.DaoLog;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.test.DbTest;

public class DaoSessionConcurrentWALTest extends DaoSessionConcurrentTest {

    @Override
    protected SQLiteDatabase createDatabase() {
        int MODE_ENABLE_WRITE_AHEAD_LOGGING = 8;
        if (DbTest.inMemory) {
            return SQLiteDatabase.create(null, "key");
        } else {
            getContext().deleteDatabase(DB_NAME);
            File databaseFile = getContext().getDatabasePath("demo.db");
            return SQLiteDatabase.openOrCreateDatabase(databaseFile, "key", null);
        }
    }

    //Don't have this method on sqlcipher
    /*public void testConcurrentLockAndQueryDuringTxWAL() throws InterruptedException {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                Method method = db.getClass().getMethod("isWriteAheadLoggingEnabled");
                boolean walEnabled = (Boolean) method.invoke(db);
                if (!walEnabled) {
                    throw new RuntimeException("WAL is disabled. This test will deadlock without WAL");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            DaoLog.e("Sorry, we need at least API level 16 for WAL");
            return;
        }

        final TestEntity entity = createEntity(null);
        dao.insert(entity);
        final Query<TestEntity> query = dao.queryBuilder().build();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                synchronized (query) {
                    query.forCurrentThread().list();
                }
            }
        };

        initThreads(runnable1);
        // Builds the statement so it is ready immediately in the thread
        query.list();
        doTx(new Runnable() {
            @Override
            public void run() {
                synchronized (query) {
                    query.list();
                }
            }
        });
        latchThreadsDone.await();
    }*/
}
