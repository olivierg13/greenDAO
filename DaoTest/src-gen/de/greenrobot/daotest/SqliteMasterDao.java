package de.greenrobot.daotest;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import de.greenrobot.daotest.SqliteMaster;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SQLITE_MASTER".
*/
public class SqliteMasterDao extends AbstractDao<SqliteMaster, Void> {

    public static final String TABLENAME = "SQLITE_MASTER";

    /**
     * Properties of entity SqliteMaster.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Type = new Property(0, String.class, "type", false, "TYPE");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property TableName = new Property(2, String.class, "tableName", false, "tbl_name");
        public final static Property Rootpage = new Property(3, Long.class, "rootpage", false, "ROOTPAGE");
        public final static Property Sql = new Property(4, String.class, "sql", false, "SQL");
    };


    public SqliteMasterDao(DaoConfig config) {
        super(config);
    }
    
    public SqliteMasterDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, SqliteMaster entity) {
        stmt.clearBindings();
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(1, type);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String tableName = entity.getTableName();
        if (tableName != null) {
            stmt.bindString(3, tableName);
        }
 
        Long rootpage = entity.getRootpage();
        if (rootpage != null) {
            stmt.bindLong(4, rootpage);
        }
 
        String sql = entity.getSql();
        if (sql != null) {
            stmt.bindString(5, sql);
        }
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public SqliteMaster readEntity(Cursor cursor, int offset) {
        SqliteMaster entity = new SqliteMaster( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // type
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // tableName
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // rootpage
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // sql
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, SqliteMaster entity, int offset) {
        entity.setType(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTableName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setRootpage(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setSql(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(SqliteMaster entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(SqliteMaster entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
