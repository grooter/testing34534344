package ru.tattelecom.intercom.feature.familyaccess.addaddress;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import ru.tattelecom.intercom.feature.familyaccess.R;
import ru.tattelecom.intercom.feature.familyaccess.addaddress.registration.RegistrationFragment;
import ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeFragment;
import ru.tattelecom.intercom.feature.familyaccess.databinding.FragmentAddAddressContainerBinding;

/* compiled from: AddAddressContainerFragment.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0003\u0013\u0014\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/addaddress/AddAddressContainerFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/familyaccess/databinding/FragmentAddAddressContainerBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/familyaccess/databinding/FragmentAddAddressContainerBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "pageList", "", "Lru/tattelecom/intercom/feature/familyaccess/addaddress/AddAddressContainerFragment$Page;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setUi", "AddAddressAdapter", "Companion", "Page", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AddAddressContainerFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(AddAddressContainerFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/familyaccess/databinding/FragmentAddAddressContainerBinding;", 0))};
    public static final String LOGIN = "Логин";
    public static final String QR_CODE = "QR-код";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;
    private List<Page> pageList;

    public AddAddressContainerFragment() {
        super(R.layout.fragment_add_address_container);
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(this, FragmentAddAddressContainerBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        this.pageList = CollectionsKt.mutableListOf(new Page(LOGIN, new RegistrationFragment()), new Page("QR-код", new ScanQRCodeFragment()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final FragmentAddAddressContainerBinding getBinding() {
        return (FragmentAddAddressContainerBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUi();
    }

    private final void setUi() {
        FragmentAddAddressContainerBinding binding = getBinding();
        MaterialToolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        binding.viewPager.setAdapter(new AddAddressAdapter());
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: ru.tattelecom.intercom.feature.familyaccess.addaddress.AddAddressContainerFragment$$ExternalSyntheticLambda0
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                AddAddressContainerFragment.setUi$lambda$1$lambda$0(AddAddressContainerFragment.this, tab, i);
            }
        }).attach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$1$lambda$0(AddAddressContainerFragment this$0, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        tab.setText(this$0.pageList.get(i).getTitle());
    }

    /* compiled from: AddAddressContainerFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/addaddress/AddAddressContainerFragment$AddAddressAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "(Lru/tattelecom/intercom/feature/familyaccess/addaddress/AddAddressContainerFragment;)V", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AddAddressAdapter extends FragmentStateAdapter {
        public AddAddressAdapter() {
            super(AddAddressContainerFragment.this);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return AddAddressContainerFragment.this.pageList.size();
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int position) {
            return ((Page) AddAddressContainerFragment.this.pageList.get(position)).getFragment();
        }
    }

    /* compiled from: AddAddressContainerFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/addaddress/AddAddressContainerFragment$Page;", "", "title", "", "fragment", "Landroidx/fragment/app/Fragment;", "(Ljava/lang/String;Landroidx/fragment/app/Fragment;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Page {
        private final Fragment fragment;
        private final String title;

        public static /* synthetic */ Page copy$default(Page page, String str, Fragment fragment, int i, Object obj) {
            if ((i & 1) != 0) {
                str = page.title;
            }
            if ((i & 2) != 0) {
                fragment = page.fragment;
            }
            return page.copy(str, fragment);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component2, reason: from getter */
        public final Fragment getFragment() {
            return this.fragment;
        }

        public final Page copy(String title, Fragment fragment) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            return new Page(title, fragment);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Page)) {
                return false;
            }
            Page page = (Page) other;
            return Intrinsics.areEqual(this.title, page.title) && Intrinsics.areEqual(this.fragment, page.fragment);
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + this.fragment.hashCode();
        }

        public String toString() {
            return "Page(title=" + this.title + ", fragment=" + this.fragment + ")";
        }

        public Page(String title, Fragment fragment) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.title = title;
            this.fragment = fragment;
        }

        public final Fragment getFragment() {
            return this.fragment;
        }

        public final String getTitle() {
            return this.title;
        }
    }
}
