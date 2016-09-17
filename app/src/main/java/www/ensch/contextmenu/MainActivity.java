package www.ensch.contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2;
    String texto = "Ha marcado el item: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView) findViewById(R.id.textView1);
        tv2=(TextView) findViewById(R.id.textView2);
        tv1.setOnCreateContextMenuListener(this);
        Button boton=(Button) findViewById(R.id.button1);
        boton.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo info){
        super.onCreateContextMenu(menu,v,info);

        if(v.getId()==R.id.textView1){
            menu.setHeaderTitle(R.string.mt);
            menu.setHeaderIcon(R.mipmap.ic_launcher);
            menu.add(0,1,1,"item 1");
            menu.add(0,2,2,"item 2");
            menu.add(0,3,3,"item 3");
        }
        if(v.getId()==R.id.button1){
            menu.setHeaderTitle(R.string.mb);
            menu.setHeaderIcon(R.mipmap.ic_launcher);
            menu.add(0,4,4,"item 4");
            menu.add(0,5,5,"item 5");
            menu.add(0,6,6,"item 6");
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item){

        int id=item.getItemId();
        tv2.append("\n"+texto + id);
        return true;
    }

}