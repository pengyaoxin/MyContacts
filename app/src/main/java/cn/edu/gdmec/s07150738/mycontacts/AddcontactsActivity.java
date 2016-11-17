package cn.edu.gdmec.s07150738.mycontacts;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by hello on 2016/10/28.
 */

public class AddcontactsActivity extends AppCompatActivity{
    //声明界面控件属性
    private EditText nameEditText;
    private EditText mobileEditText;
    private EditText qqEditText;
    private EditText danweiEditText;
    private EditText addressEditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        setTitle("添加联系人");

        //获取界面控件实例
        nameEditText = (EditText)findViewById(R.id.name);
        mobileEditText = (EditText)findViewById(R.id.mobile);
        danweiEditText = (EditText)findViewById(R.id.danwei);
        qqEditText = (EditText)findViewById(R.id.qq);
        addressEditText = (EditText)findViewById(R.id.address);

    }

    //创建选项菜单

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"保存");
        menu.add(Menu.NONE,2,Menu.NONE,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    //选项菜单点击事件

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                if (!nameEditText.getText().toString().equals("")){
                    //新建User对象
                    User user = new User();
                    user.setName(nameEditText.getText().toString());
                    user.setMobile(mobileEditText.getText().toString());
                    user.setDanwei(danweiEditText.getText().toString());
                    user.setQq(qqEditText.getText().toString());
                    user.setAddress(addressEditText.getText().toString());
                    //创建数据表对象
                    ContactsTable ct = new ContactsTable(AddcontactsActivity.this);
                    //数据表增加数据
                    if (ct.addData(user)){
                        Toast.makeText(AddcontactsActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(AddcontactsActivity.this,"添加失败",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(AddcontactsActivity.this,"请先输入数据",Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
