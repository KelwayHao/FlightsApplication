package com.example.flightsapplication.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.flightsapplication.R
import com.example.flightsapplication.databinding.FragmentFlightHistoryBinding
import com.example.flightsapplication.presentation.recycler.Adapter
import com.example.flightsapplication.presentation.swipetodeletecallback.SwipeToDeleteCallback
import com.example.flightsapplication.presentation.viewmodel.HistoryFragmentViewModel
import com.example.flightsapplication.utils.dialog
import com.example.flightsapplication.utils.showSnack
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryFragment : Fragment(R.layout.fragment_flight_history) {
    private val binding by viewBinding<FragmentFlightHistoryBinding>()
    private val viewTicketModel by viewModel<HistoryFragmentViewModel>()
    private val adapter by lazy { Adapter() }

    companion object {
        const val TAG = "History fragment"
        fun newInstance() = HistoryFragment()
    }

    private val swipeToDeleteCallback = object : SwipeToDeleteCallback() {
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition

            dialog(
                message = getString(R.string.title_dialog_message),
                context = requireActivity(),
                onPositiveButtonClick = {
                    viewTicketModel.removeItem(position)?.let { flightTicket ->
                        viewTicketModel.deleteFlightTicket(flightTicket)
                    }
                    binding.recyclerFlights.adapter?.notifyItemRemoved(position)
                },
                onNegativeButtonClick = { viewTicketModel.getFlightTickets() }
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewTicketModel.getFlightTickets()
        initObserver()
    }

    private fun initObserver() {
        binding.recyclerFlights.adapter = adapter

        viewTicketModel.flightTicket.observe(viewLifecycleOwner) { listTicket ->
            adapter.submitItem(listTicket)
        }

        ItemTouchHelper(swipeToDeleteCallback).attachToRecyclerView(binding.recyclerFlights)

        viewTicketModel.snack.observe(viewLifecycleOwner) { event ->
            showSnack(requireActivity().getString(event), requireView())
        }
    }

}