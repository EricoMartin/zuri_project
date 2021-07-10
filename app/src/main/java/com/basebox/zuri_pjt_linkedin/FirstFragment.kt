package com.basebox.zuri_pjt_linkedin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.basebox.zuri_pjt_linkedin.adapter.PostAdapter
import com.basebox.zuri_pjt_linkedin.model.DummyData

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var btn: Button
    private lateinit var rcv: RecyclerView
    private val adapter = PostAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        rcv = view.findViewById<RecyclerView>(R.id.recycler)
        rcv.adapter = adapter
        rcv.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        adapter.setUpPosts(DummyData.posts)
//        view.findViewById<Button>(R.id.button_first).setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }
}