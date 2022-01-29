package shyam.gunsariya.storydigital.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import shyam.gunsariya.storydigital.data.model.DummyModel
import shyam.gunsariya.storydigital.databinding.DummyCardItemLayoutBinding

//card adapter
class CardStackAdapter(
    private val list: ArrayList<DummyModel.Data>
): RecyclerView.Adapter<CardStackAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: DummyCardItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardStackAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DummyCardItemLayoutBinding.inflate( layoutInflater)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardStackAdapter.ViewHolder, position: Int) {

        holder.binding.dummyTitle.text = list[position].text

    }

    override fun getItemCount(): Int {
        return list.size
    }
}