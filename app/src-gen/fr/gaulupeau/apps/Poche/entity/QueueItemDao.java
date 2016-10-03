package fr.gaulupeau.apps.Poche.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import fr.gaulupeau.apps.Poche.entity.QueueItem;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "QUEUE_ITEM".
*/
public class QueueItemDao extends AbstractDao<QueueItem, Long> {

    public static final String TABLENAME = "QUEUE_ITEM";

    /**
     * Properties of entity QueueItem.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property QueueNumber = new Property(1, Long.class, "queueNumber", false, "queue_number");
        public final static Property Action = new Property(2, int.class, "action", false, "ACTION");
        public final static Property ArticleId = new Property(3, Integer.class, "articleId", false, "article_id");
        public final static Property Extra = new Property(4, String.class, "extra", false, "EXTRA");
    };


    public QueueItemDao(DaoConfig config) {
        super(config);
    }
    
    public QueueItemDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"QUEUE_ITEM\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"queue_number\" INTEGER," + // 1: queueNumber
                "\"ACTION\" INTEGER NOT NULL ," + // 2: action
                "\"article_id\" INTEGER," + // 3: articleId
                "\"EXTRA\" TEXT);"); // 4: extra
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"QUEUE_ITEM\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, QueueItem entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long queueNumber = entity.getQueueNumber();
        if (queueNumber != null) {
            stmt.bindLong(2, queueNumber);
        }
        stmt.bindLong(3, entity.getAction());
 
        Integer articleId = entity.getArticleId();
        if (articleId != null) {
            stmt.bindLong(4, articleId);
        }
 
        String extra = entity.getExtra();
        if (extra != null) {
            stmt.bindString(5, extra);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public QueueItem readEntity(Cursor cursor, int offset) {
        QueueItem entity = new QueueItem( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // queueNumber
            cursor.getInt(offset + 2), // action
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // articleId
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // extra
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, QueueItem entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setQueueNumber(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setAction(cursor.getInt(offset + 2));
        entity.setArticleId(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setExtra(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(QueueItem entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(QueueItem entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}