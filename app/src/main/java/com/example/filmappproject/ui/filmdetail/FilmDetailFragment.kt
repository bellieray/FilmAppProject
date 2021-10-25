package com.example.filmappproject.ui.filmdetail

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.filmappproject.databinding.FragmentFilmDetailBinding
import com.example.filmappproject.model.Film
import com.example.filmappproject.util.getImageFromUrl
import com.example.filmappproject.viewmodel.FilmSearchViewModel

class FilmDetailFragment : Fragment() {
    private lateinit var mBinding: FragmentFilmDetailBinding
    private val mNavArgs: FilmDetailFragmentArgs by navArgs()
    private lateinit var filmModel: Film
    private lateinit var viewModel: FilmSearchViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FilmSearchViewModel::class.java)
        filmModel = mNavArgs.filmModel
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move);
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentFilmDetailBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(mBinding) {
            model = filmModel
            filmDetailImage.getImageFromUrl(filmModel.poster)
            filmDetailImageRadius.getImageFromUrl(filmModel.poster)
            detailYear.text = filmModel.year
            detailType.text = filmModel.type
            detailFilmTitle.text = filmModel.title
            imageDetailButton.setOnClickListener{
                activity?.onBackPressed()
            }
        }
    }


}
