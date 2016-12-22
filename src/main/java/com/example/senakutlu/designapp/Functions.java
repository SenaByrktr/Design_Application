package com.example.senakutlu.designapp;

/**
 * Created by Sena Kutlu on 11.12.2016.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functions {

    public static boolean isEmailValid(String email) { //mail formatt kontrol eder
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static String sha1(String data) //Sha1 sifreleme yapar
    {
        try
        {
            byte[] b = data.getBytes();
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.reset();
            md.update(b);
            byte messageDigest[] = md.digest();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < messageDigest.length; i++)
            {
                result.append(Integer.toString((messageDigest[i] & 0xff) + 0x100, 16).substring(1));
            }

            return result.toString();

        } catch (NoSuchAlgorithmException e)
        {

            //  Log.e("ARTags", "SHA1 is not a supported algorithm");
        }
        return null;
    }


    public static void resetTables(){
        // Tum verileri siler. tabloyu resetler.
        SQLiteOpenHelper helper = null;
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(Database.TABLE_USER, null, null);
        db.close();
    }

    public boolean giriskontrol(Context context){
        Database db = new Database(context);
        int count = Database.getRowCount();// databasedeki table logindeki row sayisi
        if(count > 0){//0 dan fazla ise giris yapmss onceden demek
            //kullanici giris yapmis
            return true;
        }
        return false;
    }

}