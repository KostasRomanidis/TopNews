package com.kroman.presentation.ui.bookmarks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kroman.presentation.databinding.FragmentBookmarksBinding
import com.kroman.presentation.databinding.FragmentHomeBinding
import com.kroman.presentation.ui.base.BaseFragment

class BookmarksFragment : BaseFragment() {

    private lateinit var bookmarksBinding: FragmentBookmarksBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bookmarksBinding = FragmentBookmarksBinding.inflate(inflater, container, false)
        return bookmarksBinding.root
    }
}