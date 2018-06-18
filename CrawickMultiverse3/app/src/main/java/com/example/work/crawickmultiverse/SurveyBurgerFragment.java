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
        final String question1 = ((android.widget.EditText)getView().findViewById(R.id.editText1)).getText().toString();
        final String question6 = ((android.widget.EditText)getView().findViewById(R.id.editText2)).getText().toString();
        final String question7 = ((android.widget.EditText)getView().findViewById(R.id.editText3)).getText().toString();
        final String question8 = ((android.widget.EditText)getView().findViewById(R.id.editText4)).getText().toString();

        Bundle extras = new Bundle();
        extras.putString("Number of People in Group: ", radioButton.getText().toString());
        extras.putString("Youngest Person Present: ", radioButton2.getText().toString());
        extras.putString("Oldest Person Present: ", radioButton3.getText().toString());
        extras.putString("How Far Have You Travelled: ", radioButton4.getText().toString());
        extras.putString("How Did You Find Out About Crawick Multiverse: ", radioButton5.getText().toString());
        extras.putString("Did You Download the App before your vist?: ", radioButton6.getText().toString());
        extras.putString("Did the App improve your experience at Crawick Multiverse?: ", radioButton7.getText().toString());

      android.util.Log.i("Send email", "");

      String[] TO = {"info@crawickmultiverse.co.uk"};
      //String[] CC = {"ross.houliston1@gmail.com"};
      android.content.Intent emailIntent = new android.content.Intent(android.content.Intent.ACTION_SEND);
      emailIntent.setData(android.net.Uri.parse("mailto:"));
      emailIntent.setType("text/plain");


      emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, TO);
      //emailIntent.putExtra(android.content.Intent.EXTRA_CC, CC);
      emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Crawick Multiverse Survey");
      emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,

      "1. What was the date of your visit?: " + question1
      + "\n" + "2. Number of People in Group: " + radioButton.getText().toString()
      + "\n" + "3. Youngest Person Present: " + radioButton2.getText().toString()
      + "\n" + "4. Oldest Person Present: " + radioButton3.getText().toString()
      + "\n" + "5. How Far Have You Travelled: " + radioButton4.getText().toString()
      + "\n" + "6. What was your experience of Crawick Multiverse?: " + question6
      + "\n" + "7. How did you feel while exploring Crawick Multiverse?: " + question7

      + "\n" + "8. How Did You Find Out About Crawick Multiverse: " + radioButton5.getText().toString()
      + "\n" + "8. Other: " + question8
      + "\n" + "9. Did You Download the App before your vist?: " + radioButton6.getText().toString()
      + "\n" + "10. Did the App improve your experience at Crawick Multiverse?: " + radioButton7.getText().toString()


      );


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
       android.app.AlertDialog.Builder dlgAlert  = new android.app.AlertDialog.Builder(getContext());
       dlgAlert.setMessage("Please answer ALL questions - your feedback is important to us.");
       dlgAlert.setTitle("Crawick Multiverse");
       dlgAlert.setPositiveButton("OK", null);
       dlgAlert.setCancelable(true);
       dlgAlert.create().show();




         radioGroup1 = (RadioGroup) v.findViewById(R.id.NumberOfPeopleInGroup);
         radioGroup2 = (RadioGroup) v.findViewById(R.id.YoungestPersonPresent);
         radioGroup3 = (RadioGroup) v.findViewById(R.id.OldestPersonPresent);
         radioGroup4 = (RadioGroup) v.findViewById(R.id.HowFarHaveYouTravelled);
         radioGroup5 = (RadioGroup) v.findViewById(R.id.HowDidYouFindOut);
         radioGroup6 = (RadioGroup) v.findViewById(R.id.DidYouDownloadApp);
         radioGroup7 = (RadioGroup) v.findViewById(R.id.DidAppImproveExperience);
//         radioGroup1.check(R.id.radio_1);
//         radioGroup2.check(R.id.radio_6);
//         radioGroup3.check(R.id.radio_13);
//         radioGroup4.check(R.id.radio_20);
//         radioGroup5.check(R.id.radio_24);
//         radioGroup6.check(R.id.radio_28);
//         radioGroup7.check(R.id.radio_30);


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

                Toast.makeText(getActivity(), "Submitting Survey - please access your Email application", Toast.LENGTH_SHORT).show();

                sendEmail();
            }
        });
            return v;
        }
    }
