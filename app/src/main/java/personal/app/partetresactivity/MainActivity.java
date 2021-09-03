package personal.app.partetresactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nombre, genero, edad, direccion;
    TextView mensaje;
    CheckBox terminos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText)findViewById(R.id.txbNombre);
        genero = (EditText)findViewById(R.id.txbGenero);
        edad = (EditText)findViewById(R.id.txbEdad);
        direccion = (EditText)findViewById(R.id.txbDireccion);
        mensaje = (TextView)findViewById(R.id.txtMensaje);
        terminos = (CheckBox)findViewById(R.id.cbTerminos);
    }

    public void Cancelar(View view){
        try {
            if (view.getId()==R.id.btnCancelar){
                nombre.setText("");
                genero.setText("");
                edad.setText("");
                direccion.setText("");
                terminos.setChecked(false);
            }
        }catch (Exception e){
            mensaje.setTextColor(Color.RED);
            mensaje.setText("Ocurrio un Error:\n"+"Revise los datos");
        }

    }

    public void Registrar(View view){
        try {
            if (view.getId()==R.id.btnRegistrar){
                int ed = Integer.parseInt(edad.getText().toString());

                if (ed<18){
                    mensaje.setTextColor(Color.RED);
                    mensaje.setText("Usted es menor de edad, no\n" +
                            "se puede registrar");
                }else{
                    mensaje.setTextColor(Color.BLACK);
                    mensaje.setText("BIENVENIDO "+nombre.getText().toString());
                }
            }
        }catch (Exception e){
            mensaje.setTextColor(Color.RED);
            mensaje.setText("Ocurrio un Error:\n"+"Revise los datos");
        }

    }


}