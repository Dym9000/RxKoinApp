package com.example.rxkoinapp.ui.missions_display

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxkoinapp.R
import com.example.rxkoinapp.databinding.FragmentMissionsDisplayBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 *  Design of the UI is not very pleasant for the eyes - I focused more on the technical aspect
 *  of the task, which was to learn Koin, JavaRx and Unit Testing.
 */

class MissionsDisplayFragment : Fragment() {

    private val missionViewModel by viewModel<MissionDisplayViewModel>()
    private lateinit var binding: FragmentMissionsDisplayBinding
    private lateinit var missionAdapter: MissionDisplayAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_missions_display, container, false)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = missionViewModel
        }

        setRecyclerView()
        setObservers()

        return binding.root
    }

    private fun setRecyclerView(){
        missionAdapter = MissionDisplayAdapter()
        binding.recyclerViewMissionsDisplay.recyclerViewMissions.apply {
            adapter = missionAdapter
            layoutManager = LinearLayoutManager(requireActivity())
        }
    }

    private fun setObservers(){
        missionViewModel.missions.observe(viewLifecycleOwner, {
            if(it.data != null){
                missionAdapter.submitList(it.data)}
            else{
                Toast.makeText(requireActivity(), it.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}