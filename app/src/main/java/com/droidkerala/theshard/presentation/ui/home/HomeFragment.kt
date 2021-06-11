package com.droidkerala.theshard.presentation.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.droidkerala.theshard.data.Movie
import com.droidkerala.theshard.databinding.FragmentHomeBinding
import com.droidkerala.theshard.presentation.ui.adapters.PopularMoviesAdapter
import com.droidkerala.theshard.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import io.shrineapps.divinevibes.ui.theme.Red700
import io.shrineapps.divinevibes.ui.theme.Red800
import io.shrineapps.divinevibes.ui.theme.Red900
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {


    private val lightColors = lightColors(
        primary = Red700,
        primaryVariant = Red900,
        onPrimary = Color.Black,
        secondary = Red700,
        secondaryVariant = Red900,
        onSecondary = Color.Black,
        error = Red800,
    )

    private val darkColors = darkColors(
        primary = Red700,
        primaryVariant = Red900,
        onPrimary = Color.White,
        secondary = Red700,
        secondaryVariant = Red900,
        onSecondary = Color.White,
        error = Red800
    )


    private var _binding: FragmentHomeBinding? = null

    private val homeViewModel: HomeViewModel by viewModels()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.recyclerPopularMovies.apply {
            adapter = PopularMoviesAdapter(null)
        }
        // Todo Tmdb API here
        homeViewModel.getMovies("",1).observe(viewLifecycleOwner,{
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        Log.d("hai", resource.data.toString())
                        resource.data?.results?.let { it1 ->
                            (binding.recyclerPopularMovies.adapter as PopularMoviesAdapter).setData(
                                it1
                            )
                        }
                    }
                    Status.ERROR -> {
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {

                    }
                }
            }
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}