package com.sayantanbanerjee.todolist.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.sayantanbanerjee.todolist.data.ToDoContract.ToDoEntry;

public class ToDoProvider extends ContentProvider {
    private ToDoDbHelper mDbHelper;

    //Add Uri Matcher
    private static final int TODO = 100;
    private static final int TODO_ID = 101;
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        sUriMatcher.addURI(ToDoContract.CONTENT_AUTHORITY,ToDoContract.PATH_TODO,TODO);
        sUriMatcher.addURI(ToDoContract.CONTENT_AUTHORITY,ToDoContract.PATH_TODO + "/#",TODO_ID);
    }


    @Override
    public boolean onCreate() {
        mDbHelper = new ToDoDbHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        return null;
    }

    @Override
    public String getType(Uri uri) {

        final int match = sUriMatcher.match(uri);
        switch (match){
            case TODO:
                return ToDoEntry.CONTENT_LIST_TYPE;

            case TODO_ID:
                return ToDoEntry.CONTENT_ITEM_TYPE;

            default:
                throw new IllegalStateException("Unknown URI" + uri + " with match" + match);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
