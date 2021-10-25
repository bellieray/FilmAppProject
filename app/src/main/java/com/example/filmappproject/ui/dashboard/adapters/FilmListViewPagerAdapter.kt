package com.example.filmappproject.ui.dashboard.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.filmappproject.databinding.ItemFilmCardBinding
import com.example.filmappproject.model.Film

// Code with ❤️
// ┌──────────────────────────┐
// │ Created by Eray Belli       │
// │ ──────────────────────── │
// │ erybelli@gmail.com                 │            
// │ ──────────────────────── │
// │ 23.10.2021                  │
// └──────────────────────────┘    

class FilmListViewPagerAdapter(val filmSelected: (Film) -> Unit) : PagerAdapter() {
     val list = ArrayList<Film>()

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val model = list[position]
        val mBinding = ItemFilmCardBinding.inflate(LayoutInflater.from(container.context), container, false)
        FilmCardViewHolder(mBinding).bind(model)
        container.addView(mBinding.root)
        mBinding.root.setOnClickListener {
            filmSelected.invoke(list[position])
        }
        return mBinding.root
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getPageWidth(position: Int): Float {
        return 0.65f
    }


    fun submitList(items: List<Film>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }
}
