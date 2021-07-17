package com.droidkerala.theshard.presentation.ui.bottomsheet

import android.app.Dialog
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.viewModels
import com.droidkerala.theshard.R
import com.droidkerala.theshard.databinding.FragementBottomSheetDetailBinding
import com.droidkerala.theshard.presentation.ui.home.HomeViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailBottomSheet : BottomSheetDialogFragment() {

    private lateinit var fragmentBottomSheet: FragementBottomSheetDetailBinding

    private val homeViewModel: HomeViewModel by viewModels()

    var id : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getString("id")
        }
    }

//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        val bottomSheetDialog: BottomSheetDialog = BottomSheetDialog(
//            requireContext(),
//            R.style.BottomSheetStyle
//        )
//
//        bottomSheetDialog.setOnShowListener {
//            if (it is BottomSheetDialog) {
//                val view = it.findViewById<View>(R.id.design_bottom_sheet)
//                if (view is FrameLayout) {
//                    BottomSheetBehavior.from(view).state = BottomSheetBehavior.STATE_EXPANDED
//                }
//            }
//        }
//        return bottomSheetDialog
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog?.setCanceledOnTouchOutside(true)
        dialog?.setCancelable(true)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        fragmentBottomSheet = FragementBottomSheetDetailBinding.inflate(inflater, container, false)
        fragmentBottomSheet.movie = id?.let { homeViewModel.getMovieListById(it) }
        return fragmentBottomSheet.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    }

    companion object {
        const val TAG: String = "MovieDetailBottomSheet"
        fun newInstance(id: String): MovieDetailBottomSheet {
            return MovieDetailBottomSheet().apply {
                arguments = Bundle().apply {
                    putString("id",id)
                }
            }
        }
    }
}