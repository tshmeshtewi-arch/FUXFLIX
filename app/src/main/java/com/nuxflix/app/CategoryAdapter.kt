package com.nuxflix.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(
    private val items: List<CategoryItem>,
    private val onClick: (CategoryItem) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category_card, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { onClick(item) }
    }

    override fun getItemCount() = items.size

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val card: CardView = itemView as CardView
        private val emoji: TextView = itemView.findViewById(R.id.category_emoji)
        private val name: TextView = itemView.findViewById(R.id.category_name)

        fun bind(item: CategoryItem) {
            emoji.text = item.emoji
            name.text = item.name
            card.setCardBackgroundColor(ContextCompat.getColor(itemView.context, item.colorRes))
        }
    }
}
