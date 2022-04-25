package com.example.mop_marketorganicproducts_WesleyZanon.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mop_marketorganicproducts_WesleyZanon.R;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mop_marketorganicproducts_WesleyZanon.R;
import com.example.mop_marketorganicproducts_WesleyZanon.helper.configuracaoFireBase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;




public class CadastrarActivity extends AppCompatActivity {


    private Button botaoCadastrar;
    private EditText campoNome, campoEmail, campoSenha;

    private FirebaseAuth autenticacao = configuracaoFireBase.getReferenciaAutenticacao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        inicializarComponentes();

        //11/12/200

    }


    private void inicializarComponentes(){

        campoNome = findViewById(R.id.editCadastroNome);
        campoEmail = findViewById(R.id.editCadastroEmail);
        campoSenha = findViewById(R.id.editCadastroSenha);
        botaoCadastrar = findViewById(R.id.botaoCadastrar);
    }


}