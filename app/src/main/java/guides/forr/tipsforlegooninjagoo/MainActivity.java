package guides.forr.tipsforlegooninjagoo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    View view_one,view_two,view_three,view_four,rate_us_view;
    Button privacy_policy;

    public  static int  index;
    Intent intent;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ////////////////////////////////////
        view_one =findViewById(R.id.view_one);
        view_two =findViewById(R.id.view_two);
        view_three =findViewById(R.id.view_three);
        view_four =findViewById(R.id.view_four);

        rate_us_view =findViewById(R.id.rate_you);

        rate_us_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String appPackageName = getPackageName();
                try {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + appPackageName)));
                    return;
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                    return;
                }

            }
        });
        privacy_policy =findViewById(R.id.privacy_policy);

        privacy_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                show_privacy();
            }
        });

        view_one.setOnClickListener(this);
        view_two.setOnClickListener(this);
        view_three.setOnClickListener(this);
        view_four.setOnClickListener(this);




        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the interstitial ad is closed.

                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                startActivity(intent);
            }
        });










    }


    @Override
    public void onClick(View view) {

        intent = new Intent(MainActivity.this,DetailActivity.class);

        switch (view.getId())
        {
            case R.id.view_one:
                index =1;
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                    startActivity(intent);
                }

                break;
            case R.id.view_two:
                index =2;
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                    startActivity(intent);
                }
                break;
            case R.id.view_three:
                index =3;
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                    startActivity(intent);
                }

                break;
            case R.id.view_four:
                index =4;
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                    startActivity(intent);
                }
                break;
            default:
                break;
        }

    }


    public void show_privacy() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
        builder1.setMessage("We built the Generador De Nombres Para Free Fire app as an Ad Supported app. This SERVICE is provided by us at no cost and is intended for use as is.  This page is used to inform visitors regarding my policies with the collection, use, and disclosure of Personal Information if anyone decided to use my Service.  If you choose to use my Service, then you agree to the collection and use of information in relation to this policy. The Personal Information that I collect is used for providing and improving the Service. I will not use or share your information with anyone except as described in this Privacy Policy.  The terms used in this Privacy Policy have the same meanings as in our Terms and Conditions, which is accessible at Generador De Nombres Para Free Fire unless otherwise defined in this Privacy Policy. Information Collection and Use  For a better experience, while using our Service, I may require you to provide us with certain personally identifiable information, including but not limited to Android advertising ID. The information that I request will be retained on your device and is not collected by me in any way.  The app does use third party services that may collect information used to identify you.  Link to privacy policy of third party service providers used by the app  Google Play Services  AdMob    I want to inform you that whenever you use my Service, in a case of an error in the app I collect data and information (through third party products) on your phone called Log Data. This Log Data may include information such as your device Internet Protocol (“IP”) address, device name, operating system version, the configuration of the app when utilizing my Service, the time and date of your use of the Service, and other statistics. Cookies  Cookies are files with a small amount of data that are commonly used as anonymous unique identifiers. These are sent to your browser from the websites that you visit and are stored on your device's internal memory.  This Service does not use these “cookie");
        builder1.setCancelable(true);
        builder1.setTitle("Privacy Policy");

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

}
