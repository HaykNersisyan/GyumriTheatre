package diploma.gyumri.theatre.view.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import diploma.gyumri.theatre.R;
import diploma.gyumri.theatre.conteins.Constants;
import diploma.gyumri.theatre.model.User;
import diploma.gyumri.theatre.request.Request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {
    @BindView(R.id.registerLogin)
    EditText login;
    @BindView(R.id.registerPassword)
    EditText password;
    @BindView(R.id.registerConfirmPassword)
    EditText confirmPassword;
    @BindView(R.id.registerName)
    EditText name;
    @BindView(R.id.registerSurName)
    EditText surName;
    @BindView(R.id.registerPhone)
    EditText phone;
    @BindView(R.id.registerEmail)
    EditText email;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick(R.id.registerBtn)
    void onClick() {
        if (fieldsValidation()) {
            if (!password.getText().toString().equals(confirmPassword.getText().toString())) {
                Toast.makeText(this, "parolner@ havasar chen", Toast.LENGTH_SHORT).show();
            }
            if (!validateEmail(email.getText().toString().trim())) {
                Toast.makeText(this, "Tamame che", Toast.LENGTH_SHORT).show();
            }
            if (!validePassword(password.getText().toString())) {
                Toast.makeText(this, "Tamame che", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Tamame", Toast.LENGTH_SHORT).show();
            }
        } else {
            Request.register(this, userCreate());
        }
    }


    private User userCreate() {
        String login = this.login.toString().trim();
        String password = this.password.toString().trim();
        String confirmPassword = this.confirmPassword.toString().trim();
        String name = this.name.toString().trim();
        String surName = this.surName.toString().trim();
        String phone = this.phone.toString().trim();
        String email = this.email.toString().trim();
        return new User(login, password, confirmPassword, name, surName, phone, email);
    }

    private boolean fieldsValidation() {
        return !login.getText().toString().trim().equals("")
                && !password.getText().toString().trim().equals("")
                && !confirmPassword.getText().toString().trim().equals("")
                && !name.getText().toString().trim().equals("")
                && !surName.getText().toString().trim().equals("")
                && !phone.getText().toString().trim().equals("")
                && !email.getText().toString().trim().equals("");
    }


    private boolean validateEmail(String emailStr) {
        Matcher matcher = Constants.VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    private boolean validePassword(String password) {
        Matcher matcher = Constants.VALID_PASSWORD_REGEX.matcher(password);
        return matcher.find();
    }
}
