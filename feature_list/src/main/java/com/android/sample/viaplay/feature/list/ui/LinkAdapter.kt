package com.android.sample.viaplay.feature.list.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.sample.common.base.BaseAdapter
import com.android.sample.common.extension.layoutInflater
import com.android.sample.core.response.Link
import com.android.sample.viaplay.feature.list.databinding.LinkItemBinding

class LinkAdapter(
    private val callback: OnClickListener
) : BaseAdapter<Link, LinkAdapter.MainViewHolder>(DiffCallback) {

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainViewHolder.from(parent)

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(getItem(position), callback)
    }

    /**
     * ViewHolder for link items. All work is done by data binding.
     */
    class MainViewHolder(private val binding: LinkItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(link: Link, callback: OnClickListener) {
            binding.link = link
            binding.callback = callback
        }

        companion object {
            fun from(parent: ViewGroup): MainViewHolder {
                val binding = LinkItemBinding.inflate(
                    parent.context.layoutInflater,
                    parent,
                    false
                )
                return MainViewHolder(binding)
            }
        }
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of [Link]
     * has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<Link>() {
        override fun areItemsTheSame(
            oldItem: Link, newItem: Link
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Link, newItem: Link
        ): Boolean = oldItem == newItem
    }

    /**
     * Custom listener that handles clicks on [RecyclerView] items.  Passes the [Link]
     * associated with the current item to the [onClick] function.
     * @param clickListener lambda that will be called with the current [Link]
     */
    class OnClickListener(val clickListener: (link: Link) -> Unit) {
        fun onClick(link: Link) = clickListener(link)
    }
}