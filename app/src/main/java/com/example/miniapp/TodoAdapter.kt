package com.example.miniapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miniapp.databinding.ItemTodoBinding

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    private val todoList = arrayListOf<Model>()
    lateinit var NavigateToDetail: (id: Int) -> Unit

    inner class TodoViewHolder(val itemTodoBinging: ItemTodoBinding) :
        RecyclerView.ViewHolder(itemTodoBinging.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val item = todoList[position]

        holder.itemTodoBinging.item = item
        val adapter = ImageAdapter()
        adapter.updateMyList(item.images)
        holder.itemTodoBinging.imageViewphoto.setImageUrl(item.images[0])

        holder.itemTodoBinging.root.setOnClickListener {
            NavigateToDetail(item.id)
        }
    }

    fun updateList(newList: List<Model>) {
        todoList.clear()
        todoList.addAll(newList)
        notifyDataSetChanged()
    }
}