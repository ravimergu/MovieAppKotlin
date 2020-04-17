package com.example.myapplication.ui.main.view

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.myapplication.MyApp
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.main.adapter.MainAdapter
import com.example.myapplication.ui.main.viewModel.MainViewModel
import com.example.myapplication.utils.Status
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding

    private lateinit var mainAdapter: MainAdapter

    @Inject
    lateinit var viewModel: MainViewModel

    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        (application as MyApp).appComponent.inject(this)

        dataBinding.recyclerView.layoutManager = LinearLayoutManager(this)

        mainAdapter = MainAdapter(arrayListOf(), Glide.with(this))
        dataBinding.recyclerView.adapter = mainAdapter
        setupProgressDialog()



        viewModel.getUsers().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.LOADING -> {
                        showProgressDialog()
                    }
                    Status.SUCCESS -> {
                        mainAdapter.apply {
                            addUsers(resource.data)
                            notifyDataSetChanged()
                        }
                        dataBinding.recyclerView.visibility = View.VISIBLE

                        hideProgressDialog()
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, resource.message, Toast.LENGTH_SHORT).show()
                        dataBinding.recyclerView.visibility = View.GONE
                        hideProgressDialog()
                    }
                }

            }
        })


    }

    private fun setupProgressDialog() {
        progressDialog = ProgressDialog(this)
        progressDialog.setCancelable(false)
    }

    private fun showProgressDialog() {
        progressDialog.show()
    }

    private fun hideProgressDialog() {
        progressDialog.dismiss()
    }
}
