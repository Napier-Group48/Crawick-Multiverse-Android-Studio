package com.example.work.crawickmultiverse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class SurveyBurgerFragment extends Fragment
{
    RadioGroup radioGroup1;
    RadioButton radioButton;

    RadioGroup radioGroup2;
    RadioButton radioButton2;

    RadioGroup radioGroup3;
    RadioButton radioButton3;

    RadioGroup radioGroup4;
    RadioButton radioButton4;

    RadioGroup radioGroup5;
    RadioButton radioButton5;

    RadioGroup radioGroup6;
    RadioButton radioButton6;

    RadioGroup radioGroup7;
    RadioButton radioButton7;


    public SurveyBurgerFragment()
    {
        // Required empty public constructor

    }

    protected void sendEmail() {
      android.util.Log.i("Send email", "");

      String[] TO = {"ross.houliston1@gmail.com"};
      String[] CC = {"ross.houliston1@gmail.com"};
      android.content.Intent emailIntent = new android.content.Intent(android.content.Intent.ACTION_SEND);
      emailIntent.setData(android.net.Uri.parse("mailto:"));
      emailIntent.setType("text/plain");


      emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, TO);
      emailIntent.putExtra(android.content.Intent.EXTRA_CC, CC);
      emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Your subject");
      emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, radioButton.getText());

      try {
         startActivity(android.content.Intent.createChooser(emailIntent, "Send mail..."));
         getActivity().finish();
         android.util.Log.i("Finished sending email...", "");
      } catch (android.content.ActivityNotFoundException ex) {
         Toast.makeText(getActivity(),
         "There is no email client installed.", Toast.LENGTH_SHORT).show();
      }
   }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       final View v = inflater.inflate(R.layout.fragment_fourth_burger, container, false);

         radioGroup1 = (RadioGroup) v.findViewById(R.id.NumberOfPeopleInGroup);
         radioGroup2 = (RadioGroup) v.findViewById(R.id.YoungestPersonPresent);
         radioGroup3 = (RadioGroup) v.findViewById(R.id.OldestPersonPresent);
         radioGroup4 = (RadioGroup) v.findViewById(R.id.HowFarHaveYouTravelled);
         radioGroup5 = (RadioGroup) v.findViewById(R.id.HowDidYouFindOut);
         radioGroup6 = (RadioGroup) v.findViewById(R.id.DidYouDownloadApp);
         radioGroup7 = (RadioGroup) v.findViewById(R.id.DidAppImproveExperience);
         //radioGroup1.check(R.id.radio_1);
         //int selectedId = radioGroup1.getCheckedRadioButtonId();
         //radioButton = (RadioButton) v.findViewById(selectedId);

          radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
           final int selectedId1 = radioGroup1.getCheckedRadioButtonId();

           radioButton = (RadioButton) v.findViewById(selectedId1);

        }
    });

           radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            final int selectedId2 = radioGroup2.getCheckedRadioButtonId();
            radioButton2 = (RadioButton) v.findViewById(selectedId2);

        }
        });

            radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            final int selectedId3 = radioGroup3.getCheckedRadioButtonId();
            radioButton3 = (RadioButton) v.findViewById(selectedId3);

        }
        });

            radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            final int selectedId4 = radioGroup4.getCheckedRadioButtonId();
            radioButton4 = (RadioButton) v.findViewById(selectedId4);
        }
        });

            radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            final int selectedId5 = radioGroup5.getCheckedRadioButtonId();
            radioButton5 = (RadioButton) v.findViewById(selectedId5);
        }
        });

            radioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
             final int selectedId6 = radioGroup6.getCheckedRadioButtonId();
            radioButton6 = (RadioButton) v.findViewById(selectedId6);
        }
        });

             radioGroup7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
             final int selectedId7 = radioGroup6.getCheckedRadioButtonId();
            radioButton7 = (RadioButton) v.findViewById(selectedId7);
        }
        });
        Button button = v.findViewById(R.id.submit_button);



        button.setOnClickListener(new View.OnClickListener() {

            @Override


            public void onClick(View v) {


                //radioGroup1.check(R.id.radio_1);

                //radioButton = (RadioButton) v.findViewById(selectedId);



                // do something

                Toast.makeText(getActivity(), "Survey submitted", Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), radioButton.getText(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), radioButton2.getText(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), radioButton3.getText(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), radioButton4.getText(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), radioButton5.getText(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), radioButton6.getText(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), radioButton7.getText(), Toast.LENGTH_SHORT).show();
                sendEmail();
            }
        });
            return v;
        }
    }
