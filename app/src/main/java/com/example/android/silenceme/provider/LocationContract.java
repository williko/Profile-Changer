package com.example.android.silenceme.provider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by williams on 30/6/19.
 */

public class LocationContract {

    public static final String AUTHORITY = "com.example.android.silenceme";

    // The base content URI = "content://" + <authority>
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    // Define the possible paths for accessing data in this contract
    // This is the path for the "places" directory
    public static final String PATH_PLACES = "places";

    public static final class LocationEntry implements BaseColumns {

        // TaskEntry content URI = base content URI + path
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PLACES).build();

        public static final String TABLE_NAME = "places";
        public static final String COLUMN_PLACE_ID = "placeID";
    }
}