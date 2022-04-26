package com.example.mop_marketorganicproducts_WesleyZanon.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;


import android.content.Intent;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mop_marketorganicproducts_WesleyZanon.R;
import com.example.mop_marketorganicproducts_WesleyZanon.helper.Permissoes;
import com.example.mop_marketorganicproducts_WesleyZanon.helper.configuracaoFireBase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.graph.Graph;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import android.view.View;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;


public class CadastrarAnunciosActivity extends AppCompatActivity //chamar a interface de interacao de imagem
        implements View.OnClickListener{

    private EditText campoTitulo, campoDescricao;
    private EditText campoValor;
    private ImageView imagem1, imagem2, imagem3;


    private String[] permissoes = new String[] {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };

    //array lista para colocar as imagens e recuperar depois
    private List<String> listaFotosRecuperadas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_anuncios);

        //colocar cidades na spinner



        //valisar permissoes
        Permissoes.validarPermissoes(permissoes,this,1);


        inicializarComponentes();


    }

        public void salvarAnuncio(View view){

            String  valor = campoValor.getText().toString();
            Log.d("Salvar","Salvar Anuncio"+valor);
        }


    @Override
    public void onClick(View view) {
        //listar elementos de imagens paar ser clicados

        switch (view.getId()){  //recuperar id do item clicado
            case R.id.imagemCadastro1:
                escolherImagem(1);
                break;

            case R.id.imagemCadastro2:
                escolherImagem(2);
                break;

            case R.id.imagemCadastro3:
                escolherImagem(3);
                break;

        }
    }

    //metodo para entrar a imagem escolhida
    public void escolherImagem(int RequestCold){
    Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    startActivityForResult(i, RequestCold);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == Activity.RESULT_OK){

            //recuperar imagem
            Uri imagemSelecionada = data.getData();
            String caminhoImagem = imagemSelecionada.toString();

            //configurar imagem no imageView
            if(requestCode == 1) //verificar se a imagem escolhida
            {
                imagem1.setImageURI(imagemSelecionada);
            }else if(requestCode == 2) //verificar se a imagem escolhida
            {
                imagem2.setImageURI(imagemSelecionada);
            }else if(requestCode == 3) //verificar se a imagem escolhida
            {
                imagem3.setImageURI(imagemSelecionada);
            }

            //colocar as imagens na Array list
            listaFotosRecuperadas.add(caminhoImagem);

        }
    }

    private void inicializarComponentes(){

        campoTitulo = findViewById(R.id.EditTituloProduto);
        campoValor = findViewById(R.id.EditValorProduto);
        campoDescricao = findViewById(R.id.EditTituloProduto);

        imagem1 = findViewById(R.id.imagemCadastro1);
        imagem2 = findViewById(R.id.imagemCadastro2);
        imagem3 = findViewById(R.id.imagemCadastro3);

        imagem1.setOnClickListener(this);
        imagem2.setOnClickListener(this);
        imagem3.setOnClickListener(this);


        Locale locale = new Locale("pt", "BR");

    }

    //pegar class de permissao
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        for(int permissaoResultado : grantResults){

            //caso o usuario negue a permicao
            if(permissaoResultado == PackageManager.PERMISSION_DENIED){
                alertaValidacaoPermissao();
            }
        }

    }

    private void alertaValidacaoPermissao(){

        //alerta para negacao de permisssoes de camera
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permissoes negadas");
        builder.setMessage("Para acessar, aceite as permisssoes!");
        builder.setCancelable(false);
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        //retornar novamente
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}