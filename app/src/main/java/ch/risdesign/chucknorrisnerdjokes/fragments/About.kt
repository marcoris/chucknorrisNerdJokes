package ch.risdesign.chucknorrisnerdjokes.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ch.risdesign.chucknorrisnerdjokes.R
import ch.risdesign.chucknorrisnerdjokes.adapter.ListAdapter
import ch.risdesign.chucknorrisnerdjokes.helpers.MY_LIST_STYLE
import ch.risdesign.chucknorrisnerdjokes.model.MyListe
import kotlinx.android.synthetic.main.fragment_about.*

/**
 * A simple [Fragment] subclass.
 *
 */
class About : Fragment() {

    //Create an instance of the adapter that we want to use
    var adapter = ListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Create a dummy list of data
        val data: MutableList<MyListe> = arrayListOf()

        data.add(MyListe("${MY_LIST_STYLE} Liste (wie diese)"))
        data.add(MyListe("${MY_LIST_STYLE} 2-3 Views"))
        data.add(MyListe("${MY_LIST_STYLE} Persistente Speicherung"))
        data.add(MyListe("${MY_LIST_STYLE} Networking (externe API)"))

        //Inform the recycler view that it uses the adapter we created.
        recycler_view.adapter = adapter
        //The layout manager will tell the recycler view HOW to render the rows.
        recycler_view.layoutManager = LinearLayoutManager(view.context)
        //Set the data
        adapter.setData(data)

    }
}
