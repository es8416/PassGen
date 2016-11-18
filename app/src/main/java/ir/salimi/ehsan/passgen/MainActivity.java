package ir.salimi.ehsan.passgen;
 import java.security.SecureRandom;
 import android.content.ClipData;
 import android.content.ClipboardManager;
 import android.content.Context;
 import android.content.Intent;
 import android.graphics.Color;
 import android.os.Bundle;
 import android.os.Vibrator;
 import android.support.v7.app.AppCompatActivity;
 import android.view.View;
 import android.widget.EditText;
 import android.widget.Spinner;
 import android.widget.TextView;
 import android.widget.Toast;

//************************************************************************************* Start Point

public class MainActivity extends AppCompatActivity {

    private EditText show_pass;

    private TextView Tx_rate;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        show_pass = (EditText) findViewById(R.id.Tx_show_pass);

        Tx_rate  = (TextView) findViewById(R.id.Tx_rate);

    }


//************************************************************************ generate password button

    public void onclick_gen(View view) {

        Tx_rate.setText("");

        Spinner sp2    = (Spinner)findViewById(R.id.spinner2);

        int PassTypeId = sp2.getSelectedItemPosition();

        Spinner sp = (Spinner) findViewById(R.id.spinner);

        int length = sp.getSelectedItemPosition();

        if (PassTypeId == 0) { //****************************************************** Just Number

            String[] symbols = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

            length = length + 4;

            SecureRandom random = new SecureRandom();

            byte bytes[] = new byte[10];

            random.nextBytes(bytes);

            StringBuilder sb = new StringBuilder(length);

            for (int i = 0; i < length; i++) {

                int indexRandom = random.nextInt(symbols.length);

                sb.append(symbols[indexRandom]);
            }

            show_pass.setText(sb.toString());

        }

        if (PassTypeId == 1) { // *************************************************** Just Alphabet

            String[] symbols = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                    "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                    "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

            length = length + 4;

            SecureRandom random = new SecureRandom();

            byte bytes[] = new byte[53];

            random.nextBytes(bytes);

            StringBuilder sb = new StringBuilder(length);

            for (int i = 0; i < length; i++) {

                int indexRandom = random.nextInt(symbols.length);

                sb.append(symbols[indexRandom]);
            }

            show_pass.setText(sb.toString());

        }

        if (PassTypeId == 2) { //*************************************************** Just Character

            String[] symbols = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "=",
                    "+", "{", "}", "[", "]", "@", "#", "$", "%", "^", "&"};

            length = length + 4;

            SecureRandom random = new SecureRandom();

            byte bytes[] = new byte[24];

            random.nextBytes(bytes);

            StringBuilder sb = new StringBuilder(length);

            for (int i = 0; i < length; i++) {

                int indexRandom = random.nextInt(symbols.length);

                sb.append(symbols[indexRandom]);
            }

            show_pass.setText(sb.toString());

        }

        if (PassTypeId == 3) { //****************************************************** All Of Them

            String[] symbols = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "!", "@", "#",
                    "$", "%", "^", "&", "*", "(", ")", "-", "_", "=", "+", "{", "}",
                    "[", "]", "@", "#", "$", "%", "^", "&", "A", "B", "C", "D", "E",
                    "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                    "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e",
                    "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
                    "s", "t", "u", "v", "w", "x", "y", "z"};

            length = length + 4;

            SecureRandom random = new SecureRandom();

            byte bytes[] = new byte[87];

            random.nextBytes(bytes);

            StringBuilder sb = new StringBuilder(length);

            for (int i = 0; i < length; i++) {

                int indexRandom = random.nextInt(symbols.length);

                sb.append(symbols[indexRandom]);
            }

            show_pass.setText(sb.toString());

        }

//******************************************************************************  Text Rating Label

        if(length <= 6) {//**************************************************** Weak password Label

            Tx_rate.setTextColor(Color.rgb(255, 0, 0));

            Tx_rate.setText("ضعیف");

        }

        if(length >= 6 && length <= 8 ) {//********************************* Average password Label

            Tx_rate.setTextColor(Color.rgb(255, 111, 0));

            Tx_rate.setText("متوسط");

        }

        if(length >= 9 && length <= 11 ) {//*********************************** Good password Label

            Tx_rate.setTextColor(Color.parseColor("#2e7d32"));

            Tx_rate.setText("خوب");

        }

        if(length >= 12) {//********************************************** Excellent password Label

            Tx_rate.setTextColor(Color.parseColor("#1976d2"));

            Tx_rate.setText("عالی !!");

        }

// ******************************************************************************** vibrate Device

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        v.vibrate(20);

    }

// ******************************************************************************  Copy Text button

    public void onclick_copy(View view) {

        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        ClipData clip = ClipData.newPlainText("Pass", show_pass.getText());

        clipboard.setPrimaryClip(clip);

        Toast.makeText(MainActivity.this, "رمز کپی شد !", Toast.LENGTH_LONG).show();

    }

//  ***************************************************************************** Clear Text button

    public void onclick_clear(View view) {

        show_pass.setText("");

        Tx_rate.setText("");


    }

//  ***************************************************************************** Clear Text button

    public void onSend(View view){


        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.setType("Text/plain");

        intent.putExtra(intent.EXTRA_TEXT,show_pass.getText());

        startActivity(intent);




    }


}









