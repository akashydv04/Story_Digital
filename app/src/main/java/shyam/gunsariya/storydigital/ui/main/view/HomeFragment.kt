package shyam.gunsariya.storydigital.ui.main.view

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.yuyakaido.android.cardstackview.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import shyam.gunsariya.storydigital.data.model.DummyModel
import shyam.gunsariya.storydigital.databinding.FragmentHomeBinding
import shyam.gunsariya.storydigital.ui.main.adapter.CardStackAdapter
import shyam.gunsariya.storydigital.ui.main.viewmodel.HomeFragmentViewModel


class HomeFragment : Fragment(), CardStackListener {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModel<HomeFragmentViewModel>()
    private var dummyList : ArrayList<DummyModel.Data> = ArrayList()
    private lateinit var cardStackAdapter: CardStackAdapter
    lateinit var cardStackLayoutManager: CardStackLayoutManager
    private var current = 1
    private var total = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getDummyData()


        //observe api response
        observeData()
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.M)
    private fun observeData() {
        viewModel.listData.observe(viewLifecycleOwner,{
            Log.d("TAG", "observeData: $it")
            total = it.data.size
            binding.currentCardPosition.text = "#$current of $total"
            for (i in it.data){
                dummyList.add(i)
            }


            cardStackLayoutManager = CardStackLayoutManager(requireActivity(), this)
            cardStackLayoutManager.setStackFrom(StackFrom.Top)
            cardStackLayoutManager.setVisibleCount(3)

            cardStackLayoutManager.setTranslationInterval(5f)
            cardStackLayoutManager.setScaleInterval(0.9f)
            cardStackLayoutManager.setMaxDegree(30f)
            cardStackLayoutManager.setSwipeThreshold(0.3f)
            cardStackLayoutManager.setCanScrollHorizontal(true)
            cardStackLayoutManager.setCanScrollVertical(true)
            cardStackLayoutManager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
            cardStackLayoutManager.setDirections(Direction.HORIZONTAL)
            binding.dummyDataCard.layoutManager = cardStackLayoutManager
            cardStackAdapter = CardStackAdapter(dummyList)
            binding.dummyDataCard.adapter = cardStackAdapter

            //previous card
            binding.prev.setOnClickListener {
                if (current > 1 || current == total){
                    val setting = RewindAnimationSetting.Builder()
                        .setDirection(Direction.Left)
                        .setDuration(Duration.Normal.duration)
                        .setInterpolator(DecelerateInterpolator())
                        .build()
                    cardStackLayoutManager.setRewindAnimationSetting(setting)
                    binding.dummyDataCard.rewind()
                    current--
                    binding.currentCardPosition.text = "#$current of $total"
                }
            }

            //next card
            binding.next.setOnClickListener {
                if (current < total ){
                    val settings = SwipeAnimationSetting.Builder()
                        .setDirection(Direction.Right)
                        .setDuration(Duration.Normal.duration)
                        .setInterpolator(AccelerateInterpolator())
                        .build()
                    cardStackLayoutManager.setSwipeAnimationSetting(settings)
                    binding.dummyDataCard.swipe()
                    current+=2
                }
            }

        })
    }

    //get dummy data from api call using viewmodel class
    private fun getDummyData() {
        viewModel.getDummyData()
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {

    }

    override fun onCardSwiped(direction: Direction?) {

        if (direction == Direction.Right){
            //prev card
            if (current > 1 || current == total){
                val setting = RewindAnimationSetting.Builder()
                    .setDirection(Direction.Left)
                    .setDuration(Duration.Normal.duration)
                    .setInterpolator(DecelerateInterpolator())
                    .build()
                cardStackLayoutManager.setRewindAnimationSetting(setting)
                binding.dummyDataCard.rewind()
                current--
                binding.currentCardPosition.text = "#$current of $total"
            }
        }
        else if (direction == Direction.Left){
            //next card
            if (current < total ){
                val settings = SwipeAnimationSetting.Builder()
                    .setDirection(Direction.Right)
                    .setDuration(Duration.Normal.duration)
                    .setInterpolator(AccelerateInterpolator())
                    .build()
                cardStackLayoutManager.setSwipeAnimationSetting(settings)
                binding.dummyDataCard.swipe()
                current+=2
            }
        }
    }

    override fun onCardRewound() {

    }

    override fun onCardCanceled() {

    }

    override fun onCardAppeared(view: View?, position: Int) {

    }

    override fun onCardDisappeared(view: View?, position: Int) {

    }

}