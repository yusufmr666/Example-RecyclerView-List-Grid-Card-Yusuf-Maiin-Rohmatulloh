package dataadapter;

import com.example.projek7.R;

import java.util.ArrayList;

public class BemData {
    private static String[] bemNames = {
            "Aditiya",
            "Reza Naufal Azzami",
            "Seila Odelia Nuandini",
            "Sinta Dewi Nur Aini",
            "M. Kharis Munawir",
            "Riki Agstiya Sandra",
            "Dina Safera Malik",
            "Dewi Meliya Sefi",
            "Fahmadin Ahmad",
            "Ricky Candra Setiawan"
    };

    private static String[] bemDetails = {
            "Program Studi Pendidikan Guru Sekolah Dasar.",
            "Program Studi Pendidikan Jasmani, Kesehatan dan Rekreasi.",
            "Program Studi Pendidikan Bahasa Inggris",
            "Program Studi Pendidikan Biologi",
            "Program Studi Pendidikan Jasmani, Kesehatan dan Rekreasi",
            "Program Studi Pendidikan Jasmani, Kesehatan dan Rekreasi",
            "Program Studi Pendidikan Bahasa dan Sastra Indonesia",
            "Program Studi Pendidikan Bahasa dan Sastra Indonesia",
            "Program Studi Pendidikan Guru Sekolah Dasar",
            "Program Studi Informatika"

   };

    private static int[] bemImages = {
            R.drawable.presma,
            R.drawable.wapresma,
            R.drawable.sekum,
            R.drawable.bendum,
            R.drawable.dagri,
            R.drawable.pora,
            R.drawable.senbut,
            R.drawable.minfo,
            R.drawable.sosmas,
            R.drawable.menpora
    };

    public static ArrayList<Bem> getListData() {
        ArrayList<Bem> list = new ArrayList<>();
        for (int position = 0; position < bemNames.length; position++) {
            Bem bem = new Bem();
            bem.setName(bemNames[position]);
            bem.setDetail(bemDetails[position]);
            bem.setPhoto(bemImages[position]);
            list.add(bem);
        }
        return list;
    }
}