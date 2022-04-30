package com.example.android11;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
// 1. повторить про ООП, про интент про андроид студио, layouts, lifecycle ->2

    // 4. Объявляем(создаем) объекты
    private EditText etValue;
    private Button btnOpenNextScreen, btnWhatsapp, btnSearch, btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //2.Intent - это намерение в переводе. Иначе это действие. -> 3
//        Intent intent = new Intent(this, SecondActivity.class);
//        startActivity(intent);

        /* 3.давайте сделаем не просто переход а по нажатию на кнопку -> 4
        Linear Relative Constraint - разницу м/у constraint и relative

        перейти в xml и сверстать 4 кнопки
        по нажатию на первый открывать и передавать инфу во второй экран
         *
          */

         /* 5. стремимся к архитектуре, делить все по методам
           Что такое методы?т Зачем мы создаем методы если можно все прописать в одном можно?
           Какие бывают методы? (Возвращаемые с входными параметрами и т.д)

           Делаем метод initViews(); - объяснить зачем(показать AltENter)
           что такое родитеьский класс View - говоря человеческим языком это в целом
           визуальные элементы которые мы видим на экране(ImageView и тд)
          */


    }

    private void initView() {
        /* название отвечает за функцию - что выполняе
        делим логику дл удобства и для читабелльности
        метод создан только для инициализаци наших объектов */
        etValue = findViewById(R.id.et_value);
        btnOpenNextScreen = findViewById(R.id.btn_open_next_screen);
        btnWhatsapp = findViewById(R.id.btn_open_next_whatsapp);
        btnSearch = findViewById(R.id.btn_open_next_search);
        btnCall = findViewById(R.id.btn_open_next_call);


//        btnOpenNextScreen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                startActivity(intent); // указываем явно мэйн активити
//            }
//        });

        btnOpenNextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String valueFromEditText = etValue.getText().toString();
                intent.putExtra("value", valueFromEditText);
                startActivity(intent); // указываем явно мэйн активити
            }
        });

        btnWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // intent делятся на типы явные и не явнные - мы точно знаем что будет в итоге
                // неявные интенты - не знаем что будет после запуска
                // указываем параметры
                String phone = etValue.getText().toString();
                String url = "https://api.whatsapp.com/send?phone" + phone;
                Intent whatsappIntent = new Intent(Intent.ACTION_VIEW); //мы смоздаем намерение открыть другое приложение
                whatsappIntent.setData(Uri.parse(url)); // конвертировать - переводить
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(Intent.ACTION_WEB_SEARCH);
                searchIntent.putExtra(SearchManager.QUERY, etValue.getText().toString());
                startActivity(searchIntent);
                //query все то что находится после запятой чвляется самим значением для поиска
            }
        });

        //для выполнения звонка обычно просят разрешения от пользователя
        // найти код для того чтобы спрашивать у пользователя
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = etValue.getText().toString();
                Intent dialIntent = new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",phone,null));//необходим второй параметр в форматен uri
                startActivity(dialIntent);
            }
        });
        // задание сделать телефонный звонок через код


        // ФРАГМЕНТЫ - кусок или фрагмент, нужно для более легкого веса приложения - окно отдельное
        // на втором активити попробовать сделать фрагменты


    }
}