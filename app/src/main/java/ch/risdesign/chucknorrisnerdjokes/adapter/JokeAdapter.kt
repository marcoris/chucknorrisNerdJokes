package ch.risdesign.chucknorrisnerdjokes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ch.risdesign.chucknorrisnerdjokes.R
import ch.risdesign.chucknorrisnerdjokes.model.Joke
import kotlinx.android.synthetic.main.item_joke.view.*

/**
 * The user adapter is responsible for matching the data with the placeholder class.
 * It is also responsible for binding and recreating.
 *
 * REMEMBER: Call a notify function like [notifyDataSetChanged] to inform the Adapter class
 * that we have changed the data, else it will not rerender.
 */
class JokeAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var data: List<Joke> = arrayListOf()

    /**
     * Creates the placeholder for every data item that will be used.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //Get the class responsible for creating a code representation of the xml file.
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_joke, parent, false)
        //Now create the placeholder object with our layout
        return UserViewHolder(view)
    }

    /**
     * Return the size of data items that we currently want to display.
     */
    override fun getItemCount(): Int {
        return data.size
    }

    /**
     * Call the function for binding the data and the layout
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UserViewHolder) {
            holder.bind(data[position])
        }
    }

    /**
     * Set the new data set to this adapter
     */
    fun setData(newData: List<Joke>) {
        data = newData
        notifyDataSetChanged()
    }


    /**
     * Create our own class for binding the data with the row layout
     */
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(joke: Joke) {
            itemView.joke.text = joke.value
        }
    }


}
