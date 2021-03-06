package com.shancode.moviecatalogueshann

import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//import com.ridho.uasmoviecatalog.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.fragment_profile.*
import org.w3c.dom.Text
import java.nio.file.Files.list
import java.util.Collections.list


class ProfileFragment : Fragment() {
    // mengambil secara global
    lateinit var image: ImageView
    lateinit var title: TextView
    lateinit var subtitle: TextView
    lateinit var list: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val root = inflater.inflate(R.layout.fragment_profile, container, false)

        title = root.findViewById(R.id.title)
        subtitle = root.findViewById(R.id.subtitle)
        image = root.findViewById(R.id.image)
        list = root.findViewById(R.id.list)
//         Inflate the layout for this fragment
//         my profile

//        val ig = view?.findViewById<ImageView>(R.id.titleig)
//        val image = view?.findViewById<ImageView>(R.id.image)
//        val title = view?.findViewById<TextView>(R.id.title)
//        val subtitle = view?.findViewById<TextView>(R.id.subtitle)
//        val list = view?.findViewById<RecyclerView>(R.id.list)
//
//        if (image != null) {
//            image.setImageResource(R.drawable.my_photo)
//        }
        title.text = "Shandy Merdya Pratama"
        subtitle.text = "UAS Shandy Merdya Pratama"
        list.adapter = linkAdapter
//        if (list != null) {
//            list.adapter = linkAdapter
//        } else {
//            list?.adapter = linkAdapter
//        }
//
//
//        return inflater.inflate(R.layout.fragment_profile, container, false)
        return root
    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = ResultProfileBinding.inflate(inflater, container, false)
//        val view = binding.root
//        return view
//    }

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? { return inflater.inflate(R.layout.fragment_profile, container, false) }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//            val image = findViewById<ImageView>(R.id.image)
//            val title = findViewById<TextView>(R.id.title)
//            val subtitle = findViewById<TextView>(R.id.subtitle)
//            val list : RecyclerView = findViewById(R.id.list)
//            val image = itemView.findViewById<ImageView>(R.id.image)
//
//            image.setImageResource(R.drawable.my_photo)
//            title.text = "Shandy Merdya Pratama"
//            subtitle.text = "Web Development"
//
//            list.adapter = linkAdapter
//    }
//
//    private fun <T> findViewById(image: ImageView): Any {
//
//    }

    // Profile
    private val linkAdapter by lazy {
        val items = listOf<LinkModel>(
            LinkModel("WhatsApp", R.drawable.wa, "https://api.whatsapp.com/send?phone=082281846860"),
            LinkModel("Instagram", R.drawable.ig, "https://www.instagram.com/shndymerdyaa/"),
            LinkModel("Website", R.drawable.web, "https://github.com/ShannCode")
        )

        LinkAdapter(items, object : LinkAdapter.AdapterListener {
            override fun onClick(linktree: LinkModel) {
                Log.e("onClick", linktree.url)
                openUrl(linktree.url)
            }

        })
    }

    private fun openUrl(url: String) {
        val openUrl = Intent(Intent.ACTION_VIEW)
        openUrl.data = Uri.parse(url)
        startActivity(openUrl)
    }
}