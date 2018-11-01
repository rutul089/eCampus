package rutul.com.ecampus.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import rutul.com.ecampus.BuildConfig;
import rutul.com.ecampus.MainApplication;
import rutul.com.ecampus.R;

public class HelperMethods {
    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123;
    private static final String TAG = "HelperMethods";
    private static final String HMAC_SHA1_ALGORITHM = "";
    static boolean isPositive = false;
    private static String AesIV256 = "TH15dsaDFdfke>3?";
    private static String AesKey256 = "AE4134fdad256DDFSKL33)111{]11ddF";

    /**
     * To get the version code of application
     *
     * @param context - get contect of activity
     * @return - version code of application
     */
    public static String getAppVersionCode(Context context) {
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String version = pInfo.versionName;
            return version;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * To check whether string is valid or not.
     *
     * @param str = String
     * @return - true if string is valid else false
     */
    public static boolean checkForValidString(String str) {
        return str != null && !str.trim().equals("") && !str.trim().equals("null") && str.trim().length() > 0;
    }

    public static String checkNullForString(Object o) {
        if (checkForValidString(o == null ? null : o.toString())) {
            return o.toString().trim();
        } else {
            return "";
        }
    }

    public static String checkStringForNull(Object o) {
        if (checkForValidString(o == null ? null : o.toString())) {
            return o.toString().trim();
        } else {
            return "N/A";
        }
    }

    public static boolean checkBooleanForNull(Object o) {
        if (o != null) {
            boolean flag = Boolean.parseBoolean(o.toString());
            return flag;
        } else {
            return false;
        }
    }

    /**
     * To check whether string is valid number or not.
     *
     * @param number = String
     * @return - true if number is valid else false
     */
    public static boolean checkForValidNumber(double number) {
        boolean isValid = false;
        String expression_number = "[0-9]{8,13}+";
        Pattern pattern = Pattern.compile(expression_number,
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("" + number);
        if (matcher.matches()) {
            isValid = true;
        }

        return isValid;
    }

    /**
     * To check whether string is valid number or not.
     *
     * @param number = String
     * @return - true if number is valid else false
     */
    public static boolean checkForValidInteger(int number) {
        boolean isValid = false;
        String expression_number = "[0-9]{0,10}+";
        Pattern pattern = Pattern.compile(expression_number,
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("" + number);
        if (matcher.matches()) {
            isValid = true;
        }

        return isValid;
    }

    /**
     * To check whether string is valid number or not.
     *
     * @param number = String
     * @return - true if number is valid else false
     */
    public static boolean checkForValidLong(long number) {
        boolean isValid = false;
        String expression_number = "[0-9]{0,10}+";
        Pattern pattern = Pattern.compile(expression_number,
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("" + number);
        if (matcher.matches()) {
            isValid = true;
        }

        return isValid;
    }

    /**
     * To check whether string is valid number or not.
     *
     * @param number = String
     * @return - true if number is valid else false
     */
    public static boolean checkForValidFloat(float number) {
        boolean isValid = false;
        if ((number - (int) number) == 0.0) {
            isValid = true;
        }

        return isValid;
    }

    public static MainApplication getAppClassInstance(Context mContext) {
        return (MainApplication) mContext.getApplicationContext();
    }


//    /**
//     * To get formatted date common for Buro App
//     *
//     * @param inputDateStr String
//     * @return - Formatted string
//     */
//    public static String strToDateddMMM(String inputDateStr) {
//        try {
//            DateFormat inputFormat = new SimpleDateFormat("yyyyMMdd");
//            DateFormat outputFormat = new SimpleDateFormat("dd MMMM");
//            Date closingDate = null;
//            closingDate = inputFormat.parse(inputDateStr);
//            String outputDateStr = outputFormat.format(closingDate);
//            return outputDateStr;
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }

//    /**
//     * To get formatted date common for Buro App
//     *
//     * @param inputDateStr String
//     * @return - Formatted string
//     */
//    public static String strToDateddMMMyyyy(String inputDateStr) {
//        try {
//            DateFormat inputFormat = new SimpleDateFormat("yyyyMMdd");
//            DateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy");
//            Date closingDate = null;
//            closingDate = inputFormat.parse(inputDateStr);
//            String outputDateStr = outputFormat.format(closingDate);
//            return outputDateStr;
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }

    public static boolean isNFPBuild() {
        return BuildConfig.FLAVOR.equals("nfp");
    }

    /**
     * To check network availability
     *
     * @param context Context
     * @return - true if network is available
     */
    public static boolean checkNetwork(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);


        return (conMgr.getActiveNetworkInfo() != null)
                && conMgr.getActiveNetworkInfo().isAvailable()
                && conMgr.getActiveNetworkInfo().isConnected();

    }


    /**
     * To show toast
     *
     * @param context Context
     * @param title   String
     */
    public static void showToast(String title, Context context) {
        if (checkForValidString(title)) Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
    }

    /**
     * To show General Something went wrong toast
     *
     * @param context Context
     */
    public static void showGeneralSWWToast(Context context) {
        Toast.makeText(context, context.getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
    }

    /**
     * To show General No Internet Connection toast
     *
     * @param context Context
     */
    public static void showGeneralNICToast(Context context) {
        Toast.makeText(context, context.getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show();
    }

    /**
     * To check valid email
     *
     * @param email String
     * @return - true if email is valid
     */
    public static boolean isValidEmail(String email) {
        boolean isValid = false;
//        String expression_email = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        String expression_email = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern pattern = Pattern.compile(expression_email,
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            isValid = true;
        }

        return isValid;
    }

    /**
     * Method to hide keyboard irrespective of the component
     *
     * @param activity - Activity object
     */
    public static void hideKeyboard(Activity activity) {
        try {
            // Check if no view has focus:
            View view = activity.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Alternative-----------------
//        InputMethodManager imm = (InputMethodManager)context.getSystemService("input_method");
//        if (imm != null) {
//            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//        }

    }

    /**
     * Method to open dial pad with prefilled given number
     *
     * @param mContext    -  Context
     * @param phoneNumber - Phone number to dial
     */
    public static void dialContactPhone(Context mContext, String phoneNumber) {
        try {
            mContext.startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
        } catch (Exception e) {
            e.printStackTrace();
            HelperMethods.showToast("Not valid number", mContext);
        }
    }

    /**
     * Method to open dial pad with prefilled given number
     *
     * @param mContext -  Context
     * @param email    - Email of receiver
     * @param subject  - Subject of mail
     * @param body     - Body of the mail
     */
    public static void sendEmail(Context mContext, String[] email, String subject, String body) {
        String receivers = "";
        for (String name :
                email) {
            receivers += name + ",";
        }
        String mailto = "mailto:" + receivers +
                "?"/*+"cc=" + "alice@applabb.com" +
                "&"*/ + "subject=" + Uri.encode(subject) +
                "&body=" + Uri.encode(body);
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse(mailto));

        mContext.startActivity(emailIntent);
    }

    /**
     * Convert dp to pixel
     *
     * @param mContext - Context
     * @param dp       - Density Pixel
     */
    public static int dpToPx(Context mContext, float dp) {
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_XHIGH));
    }

    /**
     * Convert pixel to dp
     *
     * @param mContext - Context
     * @param px       - Density Pixel
     */
    public static int pxToDp(Context mContext, float px) {
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_XHIGH));
    }

    public static float convertPixelsToDp(float px) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float dp = px / (metrics.densityDpi / 160f);
        return Math.round(dp);
    }

    public static float convertDpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }

    public static String getDeviceID(Context context) {
        String DEVICE_ID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        Log.i(TAG, "getDeviceID: " + DEVICE_ID);

        TelephonyManager tManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        @SuppressLint("MissingPermission") String uuid = tManager.getDeviceId();
        Log.i(TAG, "getDeviceID: " + uuid);
        return DEVICE_ID;
    }

//    public static String getFCMId() {
//        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
//        Log.i(TAG, "getDeviceID: " + refreshedToken);
//        return refreshedToken;
//    }

    public static String getPath(Context mContext, Uri uri) {

        String path = "";
        try {
            Cursor cursor = mContext.getContentResolver().query(uri, null,
                    null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                String document_id = cursor.getString(0);
                document_id = document_id
                        .substring(document_id.lastIndexOf(":") + 1);
                cursor.close();

                cursor = mContext
                        .getContentResolver()
                        .query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                                null, MediaStore.Images.Media._ID + " = ? ",
                                new String[]{document_id}, null);
                cursor.moveToFirst();

                try {
                    path = cursor.getString(cursor
                            .getColumnIndex(MediaStore.Images.Media.DATA));
                } catch (Exception e) {
                    e.printStackTrace();
                    Uri mUri = getImageUrlWithAuthority(mContext, uri);
                    Cursor mCursor = mContext.getContentResolver().query(mUri,
                            null, null, null, null);
                    mCursor.moveToFirst();
                    String mDocument_id = mCursor.getString(0);
                    mDocument_id = mDocument_id.substring(mDocument_id
                            .lastIndexOf(":") + 1);
                    mCursor.close();

                    mCursor = mContext
                            .getContentResolver()
                            .query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                                    null, MediaStore.Images.Media._ID + " = ? ",
                                    new String[]{mDocument_id}, null);
                    mCursor.moveToFirst();

                    path = mCursor.getString(mCursor
                            .getColumnIndex(MediaStore.Images.Media.DATA));
                    mCursor.close();
                }
                cursor.close();
            }


            return path;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Uri getImageUrlWithAuthority(Context context, Uri uri) {
        InputStream is = null;
        if (uri.getAuthority() != null) {
            try {
                is = context.getContentResolver().openInputStream(uri);
                Bitmap bmp = BitmapFactory.decodeStream(is);
                return writeToTempImageAndGetPathUri(context, bmp);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null)
                        is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static Uri writeToTempImageAndGetPathUri(Context inContext,
                                                    Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(
                inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public static int getExifOrientation(String filepath) {
        int degree = 0;
        ExifInterface exif = null;
        try {
            exif = new ExifInterface(filepath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (exif != null) {
            int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, -1);
            if (orientation != -1) {
                // We only recognize a subset of orientation tag values.
                switch (orientation) {
                    case ExifInterface.ORIENTATION_UNDEFINED:
                        degree = 0;
                        break;
                    case ExifInterface.ORIENTATION_NORMAL:
                        degree = 0;
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_90:
                        degree = 90;
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_180:
                        degree = 180;
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_270:
                        degree = 270;
                        break;
                }

            }
        }

        return degree;
    }

    public static Bitmap rotateImage(Bitmap btm, int angle, boolean isToCompress) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            if (isToCompress) {
                btm.compress(Bitmap.CompressFormat.JPEG, 70, out);
            } else {
                btm.compress(Bitmap.CompressFormat.JPEG, 100, out);
            }
            btm = BitmapFactory.decodeStream(new ByteArrayInputStream(out.toByteArray()));
            return Bitmap.createBitmap(btm, 0, 0, btm.getWidth(), btm.getHeight(), matrix, true);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        return null;
    }



    public static boolean showAlertDialog(Context mContext, String Title, String message, String positiveTitle) {
        AlertDialog alertDialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(Title);
        builder.setMessage(message);
        builder.setPositiveButton(positiveTitle, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                isPositive = true;
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
        return isPositive;
    }


    //--Equipment , History , Order
    public static String totalDuration(String checkIn, String checkOut, boolean date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date date1 = null, date2 = null;
        try {
            if (HelperMethods.checkForValidString(checkIn)) {
                date1 = simpleDateFormat.parse(checkIn);
            }
            if (HelperMethods.checkForValidString(checkOut)) {
                date2 = simpleDateFormat.parse(checkOut);
            }
            long difference = date2.getTime() - date1.getTime();
            if (difference < 0) {
                return "N/A";
            }
            if (date) {
                int days = (int) (difference / (1000 * 60 * 60 * 24));
                int hours = (int) ((difference - (1000 * 60 * 60 * 24 * days)) / (1000 * 60 * 60));
                int min = (int) (difference - (1000 * 60 * 60 * 24 * days) - (1000 * 60 * 60 * hours)) / (1000 * 60);
                int sec = (int) (difference % 60);
                return (days < 10 ? "0" + days : days) + "d" + ":" + (hours < 10 ? "0" + hours : hours) + ":" + (min < 10 ? "0" + min : min) + " : " + (sec < 10 ? "0" + sec : sec);
            } else {
                int hours = (int) (difference / (1000 * 60 * 60));
                int min = (int) ((difference / (1000 * 60)) % 60);
                long sec = (int) (difference / 1000) % 60;
                hours = (hours < 0 ? -hours : hours);
                min = (min < 0 ? -min : min);
                sec = (sec < 0 ? -sec : sec);
                return (hours < 10 ? "0" + hours : hours) + ": " + (min < 10 ? "0" + min : min) + ": " + (sec < 10 ? "0" + sec : sec);
//                return (hours < 10 ? "0" + hours : hours) + "h: " + (min < 10 ? "0" + min : min) + "m: " + (sec < 10 ? "0" + sec : sec);
            }
        } catch (Exception e) {
            return Constants.NA;
        }
    }







}
