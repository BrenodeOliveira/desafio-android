package com.example.desafio_android.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.desafio_android.databinding.ItemModelBinding
import com.example.desafio_android.domain.model.RepoModel

class ReposViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding: ItemModelBinding = ItemModelBinding.bind(view)

    fun bind(repoModel: RepoModel) {
        bindRepo(repoModel)
    }

    private fun bindRepo(repoModel: RepoModel) {
        repoModel.apply {
            with(binding) {
                txtForkQtd.text = forks
                txtRepoName.text = name
                txtStarQtd.text = stars
                txtNameUser.text = user.login
                Glide.with(itemView.context).load(user.photo)
                    .diskCacheStrategy(DiskCacheStrategy.ALL).into(imgRepo)
            }
        }
    }
}