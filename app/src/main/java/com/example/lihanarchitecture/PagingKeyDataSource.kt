package com.example.lihanarchitecture

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.lihanarchitecture.model.VipUser

//https://ithelp.ithome.com.tw/articles/10224461
class PagingKeyDataSource  : PagingSource<Int,VipUser>() {
    override fun getRefreshKey(state: PagingState<Int, VipUser>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, VipUser> {
        TODO("Not yet implemented")
    }
}