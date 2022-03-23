package id.hikmah.binar.navigationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.hikmah.binar.navigationapp.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataKedua()

        val coba = ThirdFragmentArgs.fromBundle(arguments as Bundle).keyName
        binding.tvName.text = coba
    }

    private fun getData(){
        val data = arguments?.getString(FirstFragment.EXTRA_NAME)
        val person = arguments?.getParcelable("key") as Person?
        binding.tvName.text = data
    }

    private fun getDataKedua(){
        val coba = ThirdFragmentArgs.fromBundle(arguments as Bundle).keyName
        val person = ThirdFragmentArgs.fromBundle(arguments as Bundle).keyPerson

        binding.tvName.text = coba
    }

}