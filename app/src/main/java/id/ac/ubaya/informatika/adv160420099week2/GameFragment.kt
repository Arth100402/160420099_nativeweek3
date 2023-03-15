package id.ac.ubaya.informatika.adv160420099week2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation

class GameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val num1 = view.findViewById<TextView>(R.id.txtNum1)
        val num2 = view.findViewById<TextView>(R.id.txtNum2)
        val rand1 = (0..100).shuffled().last()
        val rand2 = (0..100).shuffled().last()
        num1.text = rand1.toString()
        num2.text = rand2.toString()
        var jumlah = num1.text.toString().toInt() + num2.text.toString().toInt()
        val answer = view.findViewById<TextView>(R.id.txtAnswer)
        var counter = 0



        val btnSubmit = view.findViewById<Button>(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            if (jumlah.toString() == answer.text.toString()){
                counter += 1
                val rand1 = (0..100).shuffled().last()
                val rand2 = (0..100).shuffled().last()
                num1.text = rand1.toString()
                num2.text = rand2.toString()
                jumlah = num1.text.toString().toInt() + num2.text.toString().toInt()
            }
            else {
                val action = GameFragmentDirections.actionResultFragment(counter)
                Navigation.findNavController(it).navigate(action)
            }
        }
        val txtTurn = view.findViewById<TextView>(R.id.txtTurn)
        arguments?.let {
            val playerName =
                GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }
    }
}