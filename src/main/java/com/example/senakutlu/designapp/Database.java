package com.example.senakutlu.designapp;
/**
 * Created by Sena Kutlu on 10.12.2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Sena Kutlu on 19.11.2016.
 */

public class Database extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    // DEFINING DATABASE NAME

    public static final String DATABASE_NAME = "my_app.db";

    //
    //DEFINING TABLES AND COLUMNS AS VARIABLES
    //


    //TABLE SEXTYPE

    public static final String TABLE_SEXTYPE = "TABLE_SEXTYPE";
    public static String SEX_TYPE = "SEX_TYPE";
    public static String USERSEX = "USERSEX";


    //TABLE CITYCODE

    public static final String TABLE_CITYCODE = "TABLE_CITYCODE";
    public static String CITY_CODE = "CITY_CODE";
    public static String CITY_NAME = "CITY_NAME";


    //TABLE PHONEDESC
    public static final String TABLE_PHONEDESC = "TABLE_PHONEDESC";
    public static String PHONE_TYPE = "PHONE_TYPE";
    public static String PHONE_TYPEDESC = "PHONE_TYPEDESC";


    //TABLE USER_PHONENUMBER

    public static final String TABLE_USERPHONENUMBER = "TABLE_USERPHONENUMBER";
    public static String PHONE_USERID = "USERID";
    public static String USER_PHONETYPE = "PHONETYPE";
    public static String PHONE ="PHONE";


    //TABLE ADDRESSDESC

    public static final String TABLE_ADDRESSDESC = "TABLE_ADDRESSDESC";
    public static String ADDRESSTYPE = "ADDRESSTYPE";
    public static String ADDRESSTYPEDESC = "ADDRESSTYPEDESC";


    //TABLE USER_ADDRESS

    public static final String TABLE_USERADDRESS = "TABLE_USERADDRESS";
    public static String ADDRESS_USERID = "USERID";
    public static String USER_ADDRESSTYPE = "ADDRESSTYPE";
    public static String ADDRESS = "ADDRESS";


    // TABLE ENVIRONMENTDESC

    public static final String TABLE_USERTYPE = "TABLE_USERTYPE";
    public static String USER_TYPE = "ENVIRONMENT_TYPE";
    public static String USER_TYPEDESC = "ACTIVITY_ENVIRONMENT";


    //TABLE USER

    public static final String TABLE_USER = "TABLE_USER";
    public static String USERID = "USERID";
    public static String USER_PASSWORD = "USER_PASSWORD";
    public static String FNAME = "FNAME";
    public static String LNAME = "LNAME";
    public static String USER_SEXTYPE = "SEX_TYPE";
    public static String MAIL = "MAIL";
    public static String BDATE = "BDATE";
    public static String USER_CITYCODE = "CITY_CODE";
    public static String REGISTER_DATETIME = "REGISTER_DATETIME";


    // TABLE ENVIRONMENTDESC

    public static final String TABLE_ENVIRONMENTDESC = "TABLE_ENVIRONMENTDESC";
    public static String ENVIRONMENT_TYPE = "ENVIRONMENT_TYPE";
    public static String ACTIVITY_ENVIRONMENT = "ACTIVITY_ENVIRONMENT";


    //TABLE CATEGORY

    public static final String TABLE_CATEGORY = "TABLE_CATEGORY";
    public static String CATEGORY_ID = "CATEGORY_ID";
    public static String CATEGORY = "CATEGORY";
    public static String ACTIVITY_ENVIRONMENTTYPE = "ENVIRONMENTTYPE";


    //TABLE ACTIVITY
    public static final String TABLE_ACTIVITY = "TABLE_ACTIVITY";
    public static String ACTIVITY_ID = "ACTIVITY_ID";
    public static String ACTIVITY_CATEGORY_ID = "CATEGORY_ID";
    public static String ORGANISATOR_ID = "ORGANISATOR_ID";
    public static String CREATE_DATETIME = "CREATE_DATETIME";
    public static String ACTIVITY_CITY_CODE = "CITY_CODE";
    public static String BEGINNING_DATE = "BEGGINING_DATETIME";
    public static String TERMINATE_DATE = "TERMINATE_DATETIME";
    public static String ACCEPTENCE_CONDITION = "ACCEPTENCE_CONDITION";
    public static String ACCOMODATION_DETAIL = "ACCOMODATION_DETAILS";
    public static String TRANSPORTATION_DETAIL = "TRANSPORTATION_DETAIL";
    public static String COST = "COST";
    public static String COST_DETAIL = "COST_DETAILS";


    // TABLE ACTIVITY_ATTENDER

    public static final String TABLE_ACTIVITYATTENDER = "TABLE_ACTIVITYATTENDER";
    public static String ACTIVITYY_ID = "ACTIVITY_ID";
    public static String ATTENDER_ID = "ATTENDER_ID";
    public static String ACTIVITY_REGISTER_DATETIME = "REGISTER_DATETIME";



    static Context context;
    public Database(Context view) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {     // Databesi oluşturuyoruz.Bu methodu biz çağırmıyoruz. Databese de obje oluşturduğumuzda otamatik çağırılıyor.


        //CREATE TABLE SEXTYPE

        String CREATE_SEXTYPE = "CREATE TABLE " + TABLE_SEXTYPE + "("
                + SEX_TYPE + "VARCHAR"
                + ")";
        db.execSQL(CREATE_SEXTYPE);

        //CREATE TABLE CITYCODE

        String CREATE_CITYCODE = "CREATE TABLE " + TABLE_CITYCODE + "("
                + CITY_CODE + " VARCHAR PRIMARY KEY AUTOINCREMENT,"
                + CITY_NAME + " VARCHAR NOT NULL,"
                + ")";
        db.execSQL(CREATE_CITYCODE);

        //CREATE TABLE TABLE_PHONEDESC

        String CREATE_PHONEDESC = "CREATE TABLE " + TABLE_PHONEDESC + "("
                + PHONE_TYPE + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PHONE_TYPEDESC + " VARCHAR NOT NULL,"
                + ")";
        db.execSQL(CREATE_PHONEDESC);

        //CREATE TABLE USER_PHONENUMBER

        String CREATE_USERPHONENUMBER = "CREATE TABLE " + TABLE_USERPHONENUMBER + "("
                + "FOREIGN KEY ("+PHONE_USERID+") REFERENCES "+ TABLE_USER +" ("+ USERID +")"
                + "FOREIGN KEY ("+ USER_PHONETYPE +") REFERENCES "+ TABLE_PHONEDESC +" ("+ PHONE_TYPE +")"
                + PHONE  + " VARCHAR NOT NULL,"
                + ")";
        db.execSQL(CREATE_USERPHONENUMBER);

        //CREATE TABLE TABLE_ADDRESSDESC

        String CREATE_ADDRESSDESC = "CREATE TABLE " + TABLE_ADDRESSDESC + "("
                + ADDRESSTYPE  + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ADDRESSTYPEDESC  + " VARCHAR NOT NULL,"
                + ")";
        db.execSQL(CREATE_ADDRESSDESC);


        //CREATE TABLE USER_ADDRESS

        String CREATE_USERADDRESS= "CREATE TABLE " + TABLE_USERADDRESS + "("
                + "FOREIGN KEY ("+ADDRESS_USERID+") REFERENCES "+ TABLE_USER +" ("+USERID+")"
                + "FOREIGN KEY ("+USER_ADDRESSTYPE+") REFERENCES "+ TABLE_ADDRESSDESC +" ("+ ADDRESSTYPE +")"
                +  ADDRESS   + " VARCHAR NOT NULL,"
                + ")";
        db.execSQL(CREATE_USERADDRESS);


      /*  //CREATE TABLE USER

        String CREATE_USERTYPE= "CREATE TABLE " + TABLE_USERTYPE + "("
                + USER_TYPE + " INTEGER PRIMARY KEY AUTOINCREMENT=10100,"
                + USER_TYPEDESC   + " TEXT NOT NULL,"
                + ")";
        db.execSQL(CREATE_USERTYPE);*/


        //CREATE TABLE USER

        String CREATE_USER= "CREATE TABLE " + TABLE_USER + "("
                + USERID + " INTEGER PRIMARY KEY AUTOINCREMENT=10000,"
                + USER_PASSWORD   + " VARCHAR NOT NULL,"
                + FNAME   + " VARCHAR NOT NULL,"
                + LNAME    + " VARCHAR "
                + "FOREIGN KEY ("+USER_SEXTYPE+") REFERENCES "+TABLE_SEXTYPE+" ("+SEX_TYPE+")"
                + MAIL    + " VARCHAR NOT NULL,"
                + BDATE     + " DATETIME NOT NULL,"
                + "FOREIGN KEY ("+USER_CITYCODE +") REFERENCES "+ TABLE_CITYCODE +" ("+CITY_CODE+")"
                + REGISTER_DATETIME      + " DATETIME NOT NULL,"
                + ")";
        db.execSQL(CREATE_USER);


        //CREATE TABLE ENVIRONMENTDESC

        String CREATE_ENVIRONMENTDESC= "CREATE TABLE " + TABLE_ENVIRONMENTDESC + "("
                + ENVIRONMENT_TYPE + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ACTIVITY_ENVIRONMENT + " VARCHAR NOT NULL,"
                + ")";
        db.execSQL(CREATE_ENVIRONMENTDESC);


        //CREATE TABLE CATEGORY

        String CREATE_CATEGORY= "CREATE TABLE " + TABLE_CATEGORY + "("
                + CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + CATEGORY + " VARCHAR NOT NULL,"
                +"FOREIGN KEY ("+ ACTIVITY_ENVIRONMENTTYPE +") REFERENCES "+TABLE_ENVIRONMENTDESC+" ("+ENVIRONMENT_TYPE+")"
                + ")";
        db.execSQL(CREATE_CATEGORY);


        //CREATE TABLE ACTIVITY

        String CREATE_ACTIVIY= "CREATE TABLE " + TABLE_ACTIVITY+ "("
                + ACTIVITY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT=100,"
                + "FOREIGN KEY ("+ ACTIVITY_CATEGORY_ID +") REFERENCES "+TABLE_CATEGORY+" ("+CATEGORY_ID+")"
                + "FOREIGN KEY ("+ ORGANISATOR_ID +") REFERENCES "+TABLE_USER+" ("+USERID+")"
                + CREATE_DATETIME + " DATETIME NOT NULL,"
                + "FOREIGN KEY ("+ ACTIVITY_CITY_CODE +") REFERENCES "+TABLE_CITYCODE+" ("+ CITY_CODE +")"
                + BEGINNING_DATE + " DATETIME NOT NULL,"
                + TERMINATE_DATE + " DATETIME NOT NULL,"
                + ACCEPTENCE_CONDITION + " VARCHAR,"
                + ACCOMODATION_DETAIL + " VARCHAR,"
                + TRANSPORTATION_DETAIL+ " VARCHAR,"
                + COST+ " VARCHAR,"
                + COST_DETAIL + " VARCHAR,"
                + ")";
        db.execSQL(CREATE_ACTIVIY);


        //CREATE TABLE ACTIVITY_ATTENDER

        String CREATE_ACTIVITY_ATTENDER = "CREATE TABLE " + TABLE_ACTIVITYATTENDER + "("
                + "FOREIGN KEY ("+ ATTENDER_ID +") REFERENCES "+ TABLE_USER +" ("+ USERID +")"
                + "FOREIGN KEY ("+ ACTIVITYY_ID +") REFERENCES "+ TABLE_ACTIVITY +" ("+ ACTIVITY_ID+")"
                + ACTIVITY_REGISTER_DATETIME + " DATETIME NOT NULL,"
                + ")";
        db.execSQL(CREATE_ACTIVITY_ATTENDER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }

    public void add_user(String user_password, String fname, String lname, String sextype, String mail,  String ciytcode, String bdate) {
        //kitapEkle methodu ise adı üstünde Databese veri eklemek için

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(USER_PASSWORD, user_password);
        values.put(FNAME, fname);
        values.put(LNAME, lname);
        values.put(SEX_TYPE, sextype);
        values.put(CITY_CODE,ciytcode);
        values.put(MAIL, mail);
        values.put(BDATE, bdate);
        values.put(MAIL, mail);

        db.insert(TABLE_USER, null, values);
        db.close(); //Database Bağlantısını kapattık*/
    }

    public void add_userphonenumber (int phone_userid, int user_phoneytpe, String phone) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PHONE_USERID, phone_userid);
        values.put(USER_PHONETYPE, user_phoneytpe);
        values.put(PHONE, phone);

        db.insert(TABLE_USERPHONENUMBER, null, values);
        db.close();
    }

    public void add_useraddress (int address_userid, int user_addresstpe, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ADDRESS_USERID, address_userid);
        values.put(USER_ADDRESSTYPE, user_addresstpe);
        values.put(ADDRESS, address);

        db.insert(TABLE_USERADDRESS, null, values);
        db.close();
    }

    public ArrayList<String> table_sextype(){

        SQLiteDatabase db = this.getWritableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_CITYCODE;
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<String> sextypelist = new ArrayList<String>();

        cursor.moveToFirst();
        sextypelist.add(cursor.getString(Integer.parseInt("Female")));cursor.close();
        sextypelist.add(cursor.getString(Integer.parseInt("Male")));cursor.close();
        sextypelist.add(cursor.getString(Integer.parseInt("Other")));cursor.close();

        cursor.close();
        db.close();

        return sextypelist;
    }


    public ArrayList<String> table_citycode(){

        SQLiteDatabase db = this.getWritableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_CITYCODE;
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<String> cities = new ArrayList<String>();

        cursor.moveToFirst();
        cities.add(cursor.getString(Integer.parseInt("ADANA")));
        cities.add(cursor.getString(Integer.parseInt("ADIYAMAN")));
        cities.add(cursor.getString(Integer.parseInt("AFYONKARAHİSAR")));
        cities.add(cursor.getString(Integer.parseInt("AĞRI")));
        cities.add(cursor.getString(Integer.parseInt("AMASYA")));
        cities.add(cursor.getString(Integer.parseInt("ANKARA")));
        cities.add(cursor.getString(Integer.parseInt("ANTALYA")));
        cities.add(cursor.getString(Integer.parseInt("ARTVİN")));
        cities.add(cursor.getString(Integer.parseInt("AYDIN")));
        cities.add(cursor.getString(Integer.parseInt("BALIKESİR")));
        cities.add(cursor.getString(Integer.parseInt("BİLECİK")));
        cities.add(cursor.getString(Integer.parseInt("BİNGÖL")));
        cities.add(cursor.getString(Integer.parseInt("BİTLİS")));
        cities.add(cursor.getString(Integer.parseInt("BOLU")));
        cities.add(cursor.getString(Integer.parseInt("BURDUR")));

        cursor.close();
        db.close();

        return cities;
    }

    public HashMap<String,String> table_phonedesc(){


        HashMap<String,String> table_phonedesc = new HashMap<String,String>();
        String selectQuery = "SELECT * FROM " + TABLE_PHONEDESC;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();
        table_phonedesc.put("WORK", Integer.toString(1));
        table_phonedesc.put("HOME", Integer.toString(2));


        Collection<String> phonetypedesc = table_phonedesc.values();
        Collection<String> phonetype = table_phonedesc.keySet();

        for (String item:phonetypedesc) {
            PHONE_TYPEDESC = "INSERT INTO"+ TABLE_PHONEDESC+ "(" +PHONE_TYPEDESC+ ") VALUES" +item;
        }
        for (String item:phonetype) {
            PHONE_TYPE = "INSERT INTO"+ TABLE_PHONEDESC+ "(" +PHONE_TYPE+ ") VALUES" +item;
        }

        cursor.close();
        db.close();

        return table_phonedesc;
    }

    public HashMap<String,String> table_addressdesc(){


        HashMap<String,String> table_addressdesc = new HashMap<String,String>();
        String selectQuery = "SELECT * FROM " + TABLE_ADDRESSDESC;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();
        table_addressdesc.put("WORK", Integer.toString(1));
        table_addressdesc.put("HOME", Integer.toString(2));


        Collection<String> addresstypedesc = table_addressdesc.values();
        Collection<String> addresstype = table_addressdesc.keySet();

        for (String item:addresstypedesc) {
            ADDRESSTYPEDESC = "INSERT INTO"+ TABLE_ADDRESSDESC+ "(" +ADDRESSTYPEDESC+ ") VALUES" +item;
        }
        for (String item:addresstype) {
            ADDRESSTYPE = "INSERT INTO"+ TABLE_ADDRESSDESC+ "(" +ADDRESSTYPE+ ") VALUES" +item;
        }

        cursor.close();
        db.close();

        return table_addressdesc;
    }

    public void update_user (String userid, String user_password, String fname, String lname, String user_sextype, String mail, String bdate, String user_citycode) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_PASSWORD, user_password);
        values.put(FNAME, fname);
        values.put(LNAME, lname);
        values.put(USER_SEXTYPE, user_sextype);
        values.put(MAIL, mail);
        values.put(BDATE, bdate);
        values.put(USER_CITYCODE, user_citycode);

        // updating row
        db.update(TABLE_USER, values, USERID + " = ?", new String[] { String.valueOf(userid) });
    }

    public static int getRowCount() {

        SQLiteOpenHelper helper = null;
        String countQuery = "SELECT  * FROM " + TABLE_USER;
        Cursor cursor = helper.getReadableDatabase().rawQuery(countQuery,null);
        //SQLiteDatabase db = this.getReadableDatabase();
        //Cursor cursor = db.rawQuery(countQuery, null);
        int rowCount = cursor.getCount();
        //db.close();
        cursor.close();
        // return row count
        return rowCount;
    }

    public void delete_activity (int activity_id){ //id si belli olan row u silmek için

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERPHONENUMBER, PHONE+ " = ?",null);
        db.delete(TABLE_USERADDRESS, ADDRESS+ " = ?",null);
        db.delete(TABLE_ACTIVITY, ACTIVITY_ID+ " = ?",null);
        db.delete(TABLE_ACTIVITYATTENDER, ATTENDER_ID+ " = ?",null);

        ///*************BURAYA DÖN***************
        ///
        ///
        //new String[] { String.valueOf(id) });
        db.close();
    }



    public void ADD_ACTIVITY (String activity_categoryid, String organisatorid, String cretate_datetime, String citycode,
                              String beginning_date, String terminate_date, String acceptance_condition, String accomodaiton_detail,
                              String transportation_detail, int cost, String cost_detail) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ACTIVITY_CATEGORY_ID, activity_categoryid);
        values.put(ORGANISATOR_ID, organisatorid);
        values.put(CREATE_DATETIME, cretate_datetime);
        values.put(CITY_CODE, citycode);
        values.put(BEGINNING_DATE, beginning_date);
        values.put(TERMINATE_DATE, terminate_date);
        values.put(ACCEPTENCE_CONDITION, acceptance_condition);
        values.put(ACCOMODATION_DETAIL, accomodaiton_detail);
        values.put(TRANSPORTATION_DETAIL, transportation_detail);
        values.put(COST, cost);
        values.put(COST_DETAIL, cost_detail);

        db.insert(TABLE_ACTIVITY, null, values);
        db.close();
    }



    public void ADD_ATTENDER (int activityid, int attenderid, String registerdatetime) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ACTIVITYY_ID, activityid);
        values.put(ATTENDER_ID, attenderid);
        values.put(REGISTER_DATETIME, registerdatetime);

        db.insert(TABLE_ACTIVITY, null, values);
        db.close();
    }

    public void update_activity (String activity_id, String category_id, String city_code, String beginning_date,
                                 String terminate_date, String acceptance_condition, String accomodation_detail,
                                 String transportation_detail, String cost, String cost_detail) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ACTIVITYY_ID, activity_id);
        values.put(CATEGORY_ID, category_id);
        values.put(CITY_CODE, city_code);
        values.put(BEGINNING_DATE, beginning_date);
        values.put(TERMINATE_DATE, terminate_date);
        values.put(ACCEPTENCE_CONDITION, acceptance_condition);
        values.put(ACCOMODATION_DETAIL, accomodation_detail);
        values.put(USER_CITYCODE, transportation_detail);
        values.put(USER_CITYCODE, cost);
        values.put(USER_CITYCODE, cost_detail);

        // updating row
        db.update(TABLE_ACTIVITY, values, ACTIVITY_ID + " = ?", new String[] { String.valueOf(activity_id) });
    }



   /* public int getRowCount() {

        String countQuery = "SELECT  * FROM " + TABLE_ACTIVITYATTENDER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int rowCount = cursor.getCount();
        db.close();
        cursor.close();
        // return row count
        return rowCount;
    }*/


}