package com.example.dataBinding2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.dataBinding2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setSupportActionBar(activityMainBinding.ToolBarId);

        user = new User("Cabana","Harli");

        activityMainBinding.setUser(user);

        ClickHandler handler = new ClickHandler(activityMainBinding.content.EditFirstNameId, activityMainBinding.content.EditSecondNameId);
        activityMainBinding.content.setClickHandler(handler);
    }

    public class ClickHandler {
        private EditText fName,lName;

        public ClickHandler(EditText firstName, EditText lastName) {
            setFName(firstName);
            setLName(lastName);
        }

        private void setFName(EditText firstName) { this.fName = firstName; }
        private void setLName(EditText lastName) { this.lName = lastName; }

        public void updateUser(View view){
            user.setFirstName(fName.getText().toString());
            user.setLastName(lName.getText().toString());
            fName.setText("");
            lName.setText("");
        }
    }

}
