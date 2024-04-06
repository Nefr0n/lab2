import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.AnimalBinding
import com.example.myapplication.models.Animal

class Adapter(private val listener: OnItemClickListener) : ListAdapter<Animal, Adapter.AnimalViewHolder>(AnimalDiffCallback) {

    interface OnItemClickListener {
        fun onItemClick(animal: Animal)
    }

    object AnimalDiffCallback : DiffUtil.ItemCallback<Animal>() {
        override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AnimalBinding.inflate(layoutInflater, parent, false)
        return AnimalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = getItem(position)
        holder.bind(animal)
    }

    inner class AnimalViewHolder(private val binding: AnimalBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val animal = getItem(position)
                    listener.onItemClick(animal)
                }
            }
        }

        fun bind(animal: Animal) {
            binding.animalName.text = animal.name
            binding.slogan.text = animal.characteristics.color
            binding.gp.text = animal.characteristics.gbehavior
            binding.hab.text = animal.characteristics.diet
            binding.ts.text = animal.characteristics.cname
        }
    }

    fun filter(query: String?) {
        val currentList = currentList
        val filteredList = if (query.isNullOrBlank()) {
            currentList
        } else {
            val similarAnimals = currentList.filter { it.name.contains(query, ignoreCase = true) }
            val additionalAnimals = currentList.filter { it.name.contains(query.split(" ")[0], ignoreCase = true) }
            (similarAnimals + additionalAnimals).distinctBy { it.name }
        }
        submitList(filteredList)
    }
}
