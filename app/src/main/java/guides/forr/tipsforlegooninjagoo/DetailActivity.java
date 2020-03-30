package guides.forr.tipsforlegooninjagoo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {


    private AdView mAdView;
    View view_back, view_next;
    RelativeLayout layout;

    ArrayList<Integer> arrayList_one;
    ArrayList<Integer> arrayList_two;
    ArrayList<Integer> arrayList_three;
    ArrayList<Integer> arrayList_four;

    int back_tag = 0;
    int next_tag = 0;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //////////////////////////////////////////

        view_back = findViewById(R.id.btn_back);
        view_next = findViewById(R.id.btn_next);
        layout = findViewById(R.id.layout_big);

        arrayList_one = new ArrayList<>();
        arrayList_one.add(0, R.drawable.view_one_1);
        arrayList_one.add(1, R.drawable.view_one_2);
        arrayList_one.add(2, R.drawable.view_one_3);
        arrayList_one.add(3, R.drawable.view_one_4);

        arrayList_two = new ArrayList<>();
        arrayList_two.add(0, R.drawable.page_two_1);
        arrayList_two.add(1, R.drawable.page_two_2);
        arrayList_two.add(2, R.drawable.page_two_3);
        arrayList_two.add(3, R.drawable.page_two_4);

        arrayList_three = new ArrayList<>();
        arrayList_three.add(0, R.drawable.page_three_1);
        arrayList_three.add(1, R.drawable.page_three_2);
        arrayList_three.add(2, R.drawable.page_three_3);

        arrayList_four = new ArrayList<>();
        arrayList_four.add(0, R.drawable.page_four_1);
        arrayList_four.add(1, R.drawable.page_four_2);
        arrayList_four.add(2, R.drawable.page_four_3);
        arrayList_four.add(3, R.drawable.page_four_4);

        view_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String back = String.valueOf(view_back.getTag());
                String next = String.valueOf((view_next.getTag()));

                back_tag = Integer.parseInt(back);
                next_tag = Integer.parseInt(next);

                if (back_tag == -1) {
                    return;
                }

                {
                    getIndex(back_tag,1);
                }

            }
        });


        view_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String back = String.valueOf(view_back.getTag());
                String next = String.valueOf((view_next.getTag()));
                back_tag = Integer.parseInt(back);
                next_tag = Integer.parseInt(next);

                {
                    getIndex(next_tag,2);
                }

            }
        });


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


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

            }
        });




        getIndex(0,0);

    }

    private void getIndex(int i,int increase) {

        switch (MainActivity.index)
        {
            case 1:

                Log.e("sufi", i + "");
                if (i < arrayList_one.size() )
                {
                    setBackGround(arrayList_one.get(i), i,increase,arrayList_one.size());
                }


                break;
            case 2:

                Log.e("sufi", i + "");
                if (i < arrayList_two.size() )
                {
                    setBackGround(arrayList_two.get(i), i,increase,arrayList_two.size());
                }

                break;
            case 3:

                Log.e("sufi", i + "");
                if (i < arrayList_three.size() )
                {
                    setBackGround(arrayList_three.get(i), i,increase,arrayList_three.size());
                }

                break;
            case 4:

                Log.e("sufi", i + "");
                if (i < arrayList_four.size() )
                {
                    setBackGround(arrayList_four.get(i), i,increase,arrayList_four.size());
                }

                break;
            default:
                break;
        }

    }


    private void setBackGround(int imageId, int i,int increase,int size) {

        layout.setBackgroundResource(imageId);

        if (increase ==1)  // back button click
        {
            if (i == 0) {

                view_back.setTag(0);
                view_next.setTag(1);

                return;
            }


            view_back.setTag(back_tag-1);
            view_next.setTag(next_tag-1);



        }else if (increase == 2)  // next button click
        {

            if (i< size)
            {
                view_back.setTag(back_tag+1);
                view_next.setTag(next_tag+1);
            }

        }

        if (i %2== 0)
        {
            if (mInterstitialAd.isLoaded())
            {
                mInterstitialAd.show();
            }
        }








    }


}
