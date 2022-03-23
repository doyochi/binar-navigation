package id.hikmah.binar.navigationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import id.hikmah.binar.navigationapp.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setFragmentResultListener("reqKey"){ _, bundle ->
            val result = bundle.getString("key")
            binding.viewNama2.apply {
                visibility = View.VISIBLE
                text = result
            }
        }
    }

    override fun onCreateView( //hanya untuk hubungkan layout
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //ini tempat buat ngoding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnFragmentKedua.setOnClickListener{
            val bundle = Bundle()
            bundle.putString(EXTRA_NAME, "ini data dari halaman pertama")

            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle) //jangan lupa kasih  tambahan , bundle
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
    }

}