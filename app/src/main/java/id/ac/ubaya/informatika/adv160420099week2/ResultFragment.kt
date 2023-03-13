package id.ac.ubaya.informatika.adv160420099week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation

class ResultFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnBackMain = view.findViewById<Button>(R.id.btnBackMain)
        val txtScore = view.findViewById<TextView>(R.id.txtScore)
        btnBackMain.setOnClickListener {
            val action = ResultFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
        arguments?.let {
            val score =
                ResultFragmentArgs.fromBundle(requireArguments()).score
            txtScore.text = "Your score is $score"
        }
    }
}