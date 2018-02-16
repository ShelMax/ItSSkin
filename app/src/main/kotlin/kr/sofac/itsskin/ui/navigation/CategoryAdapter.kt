package kr.sofac.itsskin.ui.navigation

import android.graphics.Color
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.category_recycler.view.*
import kr.sofac.itsskin.R
import kr.sofac.itsskin.data.model.Category
import kotlinx.android.synthetic.main.item_category.view.*
import kr.sofac.itsskin.data.model.callback.CategoryCallback
import android.widget.LinearLayout

class CategoryAdapter(private val categories : List<Category>,
                      private val isTopCategory : Boolean,
                      private val callback : CategoryCallback
                      ) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent?.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(!isTopCategory){
            holder.itemView?.categoryName?.setTextColor(Color.parseColor("#FF6C6B6B"))
//                val llp = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
//                llp.setMargins(50, 0, 0, 0)
//                itemView.categoryName.layoutParams = llp
        }
        holder.itemView.categoryName.text = categories[position].metaTitle
        if(categories[position].subcategories != null){
            holder.itemView.childCategoryRecycler.adapter = CategoryAdapter(categories[position].subcategories!!, false, callback)
            holder.itemView.childCategoryRecycler.layoutManager = LinearLayoutManager(holder.itemView.context)
            holder.itemView.expandCategory.setOnClickListener {
                holder.isExpanded = !holder.isExpanded
                notifyItemChanged(position, holder)
            }
        }
        else{
            holder.itemView.expandCategory.visibility = View.GONE
        }
        updateView(holder)
        holder.itemView.categoryNameConstraint.setOnClickListener {
            callback.categoryClick(categories[position])
        }
    }

    private fun updateView(holder: ViewHolder){
        if(holder.isExpanded){
            holder.itemView.expandCategory.setImageResource(R.drawable.arrow_up)
            holder.itemView.childCategoryRecycler.visibility = View.VISIBLE
        }
        else{
            holder.itemView.expandCategory.setImageResource(R.drawable.arrow_down)
            holder.itemView.childCategoryRecycler.visibility = View.GONE
        }
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){

        var isExpanded : Boolean = false

    }
}