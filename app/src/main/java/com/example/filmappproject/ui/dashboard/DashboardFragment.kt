package com.example.filmappproject.ui.dashboard

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.filmappproject.R
import com.example.filmappproject.databinding.CustomDialogBinding
import com.example.filmappproject.databinding.CustomDialogNoFileBinding
import com.example.filmappproject.databinding.FragmentDashboardBinding
import com.example.filmappproject.model.Film
import com.example.filmappproject.adapters.FilmListViewPagerAdapter
import com.example.filmappproject.util.getImageFromUrl
import com.example.filmappproject.util.hideKeyboard
import com.example.filmappproject.util.submitWithEnterKey
import com.example.filmappproject.viewmodel.FilmSearchViewModel

class DashboardFragment : Fragment() {
    lateinit var mBinding: FragmentDashboardBinding
    private lateinit var viewModel: FilmSearchViewModel
    private val mAdapter: FilmListViewPagerAdapter = FilmListViewPagerAdapter(::setData)
       var selectedFilm: Film? = null
       var isDialogShowing = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentDashboardBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(FilmSearchViewModel::class.java)


        return mBinding.root
    }


    override fun onResume() {
        super.onResume()
            selectedFilm?.let { setData(it) }
    }
    private fun passDataToDetail(model: Film) {
        val action = DashboardFragmentDirections.actionFilmSearchFragmentToFilmDetailFragment(model)
        val extras = FragmentNavigatorExtras(mBinding.background to "image_poster")
        findNavController().navigate(action, extras)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.apply {
            swipeRefreshLayout.setOnRefreshListener {
                swipeRefreshLayout.isRefreshing = false
            }
            viewpager.adapter = mAdapter
        }

        submitWithEnterKey(mBinding.searchEdittext, mBinding.imgSearchButton)

        if(selectedFilm == null)

        viewModel.getData("Hulk")

        mBinding.imgSearchButton.setOnClickListener {
            val text = mBinding.searchEdittext.text.toString()
                it.hideKeyboard()
            if (text.isNotEmpty()) {
                viewModel.getData(text)

            }
        }
        observeData()
    }

    private fun observeData() {
        viewModel.isLoading.observe(viewLifecycleOwner, ::observeIsLoading)

        viewModel.error.observe(viewLifecycleOwner, ::observeError)

        viewModel.movieList.observe(viewLifecycleOwner, ::observeList)

        viewModel.isHaveSameData.observe(viewLifecycleOwner, ::observeEmptyData)
    }

    private fun setData(film: Film) {
        mBinding.apply {
            background.getImageFromUrl(film.poster)
            textViewTitle.text = film.title
            yearText.text = film.year
            typeText.text = film.type
            yearText2.text = film.year
            typeText2.text = film.type
            selectedFilm = film
            buttonDetail.setOnClickListener {
                passDataToDetail(film)
            }
        }
    }

    private fun showDialog() {
        if(!isDialogShowing) {
            isDialogShowing = true
            val builder = AlertDialog.Builder(context)
            val mBinding = CustomDialogBinding.inflate(LayoutInflater.from(context), null, false)
            val dialog = builder.setView(mBinding.root).show()

            dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
            dialog.setCanceledOnTouchOutside(true)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.setLayout(1000, 1000)
            dialog.setOnDismissListener { isDialogShowing = false }

            mBinding.dismissButton.setOnClickListener { dialog.dismiss() }
        }
    }

    private fun showNoDataDialog(){
        if(!isDialogShowing) {
            isDialogShowing = true
            val builder = AlertDialog.Builder(context)
            val mBinding = CustomDialogNoFileBinding.inflate(LayoutInflater.from(context), null, false)
            val dialog = builder.setView(mBinding.root).show()

            dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
            dialog.setCanceledOnTouchOutside(true)
            dialog.window?.setLayout(1000, 1000)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setOnDismissListener { isDialogShowing = false
            }

            mBinding.dialogDismissButton.setOnClickListener{dialog.dismiss()}
        }
    }

    private fun observeEmptyData(it: Boolean){

            if(!it){
                mBinding.isLoading = it
                showNoDataDialog()
            }

    }

    private fun observeList(model : List<Film>){

            model?.let {
                mAdapter.submitList(it)
                if (it.size > 0){
                    setData(it.first())
                }

        }

    }

    private fun observeError(it : Boolean){
            if (it) {
                showDialog()
            }

    }

    private fun observeIsLoading(it : Boolean){

            mBinding.isLoading = it

    }


}
