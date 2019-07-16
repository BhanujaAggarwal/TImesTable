package secret.a.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    public void generate(int seekbarchangenumber)
    {

        ArrayList<String> arrayListt= new ArrayList<String>();
        for(int j=1;j<=20;j++)
        {
            arrayListt.add(Integer.toString(j*seekbarchangenumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayListt);

        listView.setAdapter(arrayAdapter);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar=(SeekBar)findViewById(R.id.seekBar);
        listView=(ListView)findViewById(R.id.listView);

        int initialNumber=10;
        int maxNumber=20;
        seekBar.setMax(maxNumber);
        seekBar.setProgress(initialNumber);

        generate(initialNumber);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min=1;
                int seekbarchangenumber;
                if(i<min)
                {
                    seekbarchangenumber=min;
                    seekBar.setProgress(seekbarchangenumber);
                }
                else
                {
                    seekbarchangenumber=i;
                }

                generate(seekbarchangenumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}
