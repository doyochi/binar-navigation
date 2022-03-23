package id.hikmah.binar.navigationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import id.hikmah.binar.navigationapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()

        val data = arguments?.getString("extra_name")
        binding.tvNama.text = data
        binding.btnToFragmentKetiga.setOnClickListener{
            val name = binding.etName.text.toString()
            caraKedua(name, it)
        }
    }
    private fun getData(){
        val data = arguments?.getString(FirstFragment.EXTRA_NAME)
        binding.tvNama.text = data
    }
    private fun caraPertama(valueFromEditText: String, it: View){
        val bundle = Bundle()
        bundle.putString("extra_name", valueFromEditText)
        it.findNavController().navigate(R.id.action_secondFragment_to_thirdFragment, bundle)
    }

    private fun  caraKedua(valueFromEditText: String, it: View) {
        val person = Person("nama", 17)
        val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment(keyName = valueFromEditText, keyPerson = person)
        it.findNavController().navigate(action)
    }
}