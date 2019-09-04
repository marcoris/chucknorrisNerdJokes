package ch.risdesign.chucknorrisnerdjokes.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ch.risdesign.chucknorrisnerdjokes.R
import ch.risdesign.chucknorrisnerdjokes.adapter.JokeAdapter
import ch.risdesign.chucknorrisnerdjokes.model.Joke
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 *
 */
class Favorites : Fragment() {

    //Create an instance of the adapter that we want to use
    var adapter = JokeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Create a dummy list of data
        val data: MutableList<Joke> = arrayListOf()
        for (i in 0..33) {
            data.add(Joke("Hansli..."))
            data.add(Joke("...ist am kacken..."))
            data.add(Joke("...und es stinkt fürchterlich"))
        }

        //Inform the recycler view that it uses the adapter we created.
        recycler_view.adapter = adapter
        //The layout manager will tell the recycler view HOW to render the rows.
        recycler_view.layoutManager = LinearLayoutManager(view.context)
        //Set the data
        adapter.setData(data)

    }
}
